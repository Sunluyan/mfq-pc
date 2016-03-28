package com.mfq.services;

import com.google.common.collect.Maps;
import com.mfq.constants.AdminConstants;
import com.mfq.constants.QiniuBucketEnum;
import com.mfq.filemanipulate.image.ImageType;
import com.mfq.utils.Config;
import com.mfq.utils.DateUtil;
import com.mfq.utils.JsonUtil;
import com.mfq.utils.RandomUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Map;

public class QiniuManipulater {

    private static final Logger logger = LoggerFactory
            .getLogger(QiniuManipulater.class);

    private static final String ACCESS_KEY = Config.getItem("qiniu_access_key");

    private static final String SECRET_KEY = Config.getItem("qiniu_secret_key");

    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    // 用于资源管理
    private static BucketManager bucketManager = new BucketManager(auth);
    private static UploadManager uploadManager = new UploadManager();

    public static String getStaticImgUpToken() {
        return getUpToken(QiniuBucketEnum.IMG0, null, null);
    }

    public static Map<String, String> getProdImgUpToken() {
        String key = buildProdKey();
        String token = getUpToken(QiniuBucketEnum.IMG1, null, key);
        Map<String, String> map = Maps.newHashMap();
        map.put("domain", QiniuBucketEnum.IMG1.getDomain());
        map.put("key", key);
        map.put("token", token);
        return map;
    }

    private static String buildProdKey() {
        return QiniuBucketEnum.IMG1.getBucket() + "/"
                + ImageType.PROD_PIC.getFlag() + "/"
                + DateUtil.formatShort(new Date()) + "/"
                + System.currentTimeMillis() + RandomUtil.getRandom(3) + ".jpg";
    }
    
    
    public static Map<String, String> getMsgImgUpToken() {
        String key = buildProdKey();
        String token = getUpToken(QiniuBucketEnum.IMG2, null, key);
        Map<String, String> map = Maps.newHashMap();
        map.put("domain", QiniuBucketEnum.IMG2.getDomain());
        map.put("key", key);
        map.put("token", token);
        return map;
    }

    @SuppressWarnings("unused")
	private static String buildMsgKey() {
        return QiniuBucketEnum.IMG2.getBucket() + "/"
                + ImageType.PROD_PIC.getFlag() + "/"
                + DateUtil.formatShort(new Date()) + "/"
                + System.currentTimeMillis() + RandomUtil.getRandom(3) + ".jpg";
    }

    public static String getBannerImgUpToken() {
        return getUpToken(QiniuBucketEnum.IMG2, null, null);
    }

    /**
     * 
     * callbackBody参数配置可以参考：
     * http://developer.qiniu.com/docs/v6/api/overview/up/response/callback.html
     * 设置指定上传策略 生成上传token
     * 
     */
    private static String getUpToken(QiniuBucketEnum bucket, Long userId,
            String key) {
        String callbackUrl = buildCallbackUrl(bucket, userId);
        return auth.uploadToken(bucket.getBucket(), key, 3600,
                new StringMap().put("callbackUrl", callbackUrl)
                        .put("callbackBody", "key=$(key)&sign=$(etag)"));
    }

    private static String buildCallbackUrl(QiniuBucketEnum bucket,
            Long userId) {
        String callbackUrl = null;
        callbackUrl = AdminConstants.WEB_SITE
                + AdminConstants.QINIU_CALLBACK_FORAPP + bucket.getBucket()
                + "/"; // 用于判断是否是用户上传目录
        if (userId != null && userId > 0) {
            callbackUrl += userId;
        }
        return callbackUrl;
    }

    /**
     * 删除七牛空间中的文件
     * 
     * @param bucket：空间
     * @param key：key
     */
    public static void deleteByKey(QiniuBucketEnum bucket, String key) {
        try {
            bucketManager.delete(bucket.getBucket(), key);
            logger.info("qiniu delete file ok, bucket:{}, key:{}",
                    bucket.getBucket(), key);
        } catch (QiniuException e) {
            logger.error("QINIU_DELETE_FILE_WRONG", e);
        }
    }

    /**
     * ueditor + qiniu后端实现 ueditor的二次开发只针对controller.jsp文件进行+config.json中图片路径修改
     * 
     * @return
     */
    public static String ueditorPlusQiniu(HttpServletRequest request,
            String resp, String rootPath) {
        logger.info("====org upload ret is:{}, rootPath:{}", resp, rootPath);
        try {
            if (StringUtils.equalsIgnoreCase(request.getParameter("action"),
                    "uploadimage")) {
                // 处理图片上传逻辑,只处理正常的处理逻辑
                logger.info("###########do4pic_upload process#############");
                Map<String, Object> map = JsonUtil.getMapFromJsonStr(resp);
                if (StringUtils.equalsIgnoreCase("SUCCESS",
                        (String) map.get("state")) && map.get("url") != null) {
                    String filePath = (String) map.get("url");
                    File file = new File(rootPath + filePath);
                    if (file.exists()) {
                        String qiniuImgUrl = qiniuUploadProdImg(file);
                        map.put("url", qiniuImgUrl);
                        resp = JsonUtil.writeToJson(map);
                    }
                } else {
                    // do nothing for upload error case!
                }
            }
        } catch (Exception e) {
            logger.error("ueditor + qiniu upload error", e);
        }
        logger.info("====after upload ret is:{}", resp);
        return resp;
    }

    /**
     * 返回上传成功后的url，若异常返回null
     * 
     * @param file
     * @return
     */
    public static String qiniuUploadProdImg(File file) {
        String url = null;
        if (file != null && file.exists()) {
            Map<String, String> prodMap = getProdImgUpToken();
            logger.info("file is:{}, prodMap is:{}", file, prodMap);
            try {
                uploadManager.put(file, prodMap.get("key"),
                        prodMap.get("token"));
            } catch (QiniuException ex) {
                logger.warn("IGNORE_NULL_WRONG");
            }
            logger.info("qiniu upload is end");
            // 默认不抛其它异常，暂定为上传成功，这里有坑！！！！！！！！

            // delete local file
            file.delete();

            // 域名使用prod的
            url = QiniuBucketEnum.IMG1.getDomain() + prodMap.get("key");
        }
        logger.info("----Alter upload2Qiniu,delete local file, new file url={}",
                url);
        return url;
    }
    
    
    /**
     * 返回上传成功后的url，若异常返回null
     * 
     * @param file
     * @return
     */
    public static String qiniuUploadNotificationImg(File file) {
        String url = null;
        if (file != null && file.exists()) {
            Map<String, String> prodMap = getMsgImgUpToken();
            logger.info("file is:{}, prodMap is:{}", file, prodMap);
            try {
                uploadManager.put(file, prodMap.get("key"),
                        prodMap.get("token"));
            } catch (QiniuException ex) {
                logger.warn("IGNORE_NULL_WRONG {}");
            }
            logger.info("qiniu upload is end");
            // 默认不抛其它异常，暂定为上传成功，这里有坑！！！！！！！！

            // delete local file
            file.delete();

            // 域名使用prod的
            url = QiniuBucketEnum.IMG2.getDomain() + prodMap.get("key");
        }
        logger.info("----Alter upload2Qiniu,delete local file, new file url={}",
                url);
        return url;
    }
    
    
    /**
     * 返回上传成功后的url，若异常返回null
     * 
     * @param file
     * @return
     */
    public static String qiniuUploadImg(File file, QiniuBucketEnum qiniuBucketEnum, ImageType Itype, String fileName) {
        
    	if(fileName.length() > 4){
    		fileName = System.currentTimeMillis() + RandomUtil.getRandom(3)+fileName.substring(fileName.length() - 4, fileName.length());
    	}
        String key = qiniuBucketEnum.getBucket() + "/"
                + Itype.getFlag() + "/"
                + DateUtil.formatShort(new Date()) + "/"
                + fileName;
        
        String token = getUpToken(qiniuBucketEnum, null, key);
        Map<String, String> map = Maps.newHashMap();
        map.put("domain", qiniuBucketEnum.getDomain());
        map.put("key", key);
        map.put("token", token);
    	
    	String url = null;
        if (file != null && file.exists()) {
            logger.info("file is:{}, prodMap is:{}", file, map);
            try {
                uploadManager.put(file, map.get("key"),
                		map.get("token"));
            } catch (QiniuException ex) {
                logger.warn("IGNORE_NULL_WRONG {}");
            }
            logger.info("qiniu upload is end");
            // 默认不抛其它异常，暂定为上传成功，这里有坑！！！！！！！！

            // delete local file
            file.delete();

            // 域名使用prod的
            url = qiniuBucketEnum.getDomain() + map.get("key");
        }
        logger.info("----Alter upload2Qiniu,delete local file, new file url={}",
                url);
        return url;
    }
    
    
}