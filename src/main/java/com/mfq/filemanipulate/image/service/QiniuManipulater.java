package com.mfq.filemanipulate.image.service;

import com.google.common.collect.Maps;
import com.mfq.constants.Constants;
import com.mfq.constants.QiniuBucketEnum;
import com.mfq.dataservice.context.AppContext;
import com.mfq.filemanipulate.image.ImageType;
import com.mfq.payment.util.yeepay.common.RandomUtil;
import com.mfq.utils.Config;
import com.mfq.utils.DateUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * 七牛空间管理 avatar:头像专用空间, visit by: avatar.mfqzz.com/p1 img1:产品图片空间, visit
 * by:img1.mfqzz.com/p1 img2:产品图片空间－广告/banner等, visit by: img2.mfqzz.com/p1
 * static包含script/css文件夹, visit by: static.mfqzz.com/script/,
 * static.mfqzz.com/css
 * 
 * @author xingyongshan
 *
 */
public class QiniuManipulater {

    private static final Logger logger = LoggerFactory
            .getLogger(QiniuManipulater.class);

    private static final String ACCESS_KEY = Config.getItem("qiniu_access_key");

    private static final String SECRET_KEY = Config.getItem("qiniu_secret_key");

    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    private static UploadManager uploadManager = new UploadManager();


    // 用于资源管理
    private static BucketManager bucketManager = new BucketManager(auth);

    // avatar为头像专用空间
    public static Map<String, String> getAvatarUpToken(Long userId) {
        if (userId == null || userId <= 0) {
            return null;
        }
        // 头像需要覆盖上传-改为了新的key，原key再回调的时候删除
        String key = buildAvatarKey(ImageType.AVATAR, userId);
        String token = getUpToken(QiniuBucketEnum.AVATAR, userId, key);
        Map<String, String> map = Maps.newHashMap();
        map.put("domain", QiniuBucketEnum.AVATAR.getDomain());
        map.put("key", key);
        map.put("token", token);
        return map;
    }
    
    // 认证空间
    public static Map<String, String> getAuthUpToken(Long userId, String f) {
        if (userId == null || userId <= 0) {
            return null;
        }
        //  
        String key = buildAuthKey(ImageType.AUTH, userId, f);
        String token = getUpToken(QiniuBucketEnum.AUTH, userId, key);
        Map<String, String> map = Maps.newHashMap();
        map.put("domain", QiniuBucketEnum.AUTH.getDomain());
        map.put("key", key);
        map.put("token", token);
        return map;
    }

    private static String buildAvatarKey(ImageType type, long userId) {
        return QiniuBucketEnum.AVATAR.getBucket() + "/" + type.getFlag() + "/u_"
                + userId
                + "_"
                + System.currentTimeMillis()
                + ".jpg";
        
    }
    
    private static String buildAuthKey(ImageType type, long userId, String f) {
        return QiniuBucketEnum.AUTH.getBucket() + "/" + type.getFlag() + "/auth_"+f
                + userId
                + "_"
                + System.currentTimeMillis()
                + ".jpg";
        
    }

    private static String buildCommonKey(ImageType type) {
        return QiniuBucketEnum.IMG1.getBucket() + "/" + type.getFlag() + "/"
                + DateUtil.formatShort(new Date()) + "/"
                + System.currentTimeMillis() + RandomUtil.getRandom(3);
    }

    public static String getStaticImgUpToken() {
        return getUpToken(QiniuBucketEnum.IMG0, null, null);
    }

    public static String getProdImgUpToken() {
        String key = buildCommonKey(ImageType.PROD_PIC);
        return getUpToken(QiniuBucketEnum.IMG1, null, key);
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
     * @param bucket
     *            空间名
     * @param key
     *            key，可为 null,若非null则表示覆盖上传
     *            有效时长，单位秒。默认3600s
     *
     *            上传策略的其它参数，如 new StringMap().put("endUser",
     *            "uid").putNotEmpty("returnBody", "")。 scope通过
     *            bucket、key间接设置，deadline 通过 expires 间接设置
     *            是否去除非限定的策略字段，默认true
     * @return 生成的上传token
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
        if (AppContext.isApp()) {
            callbackUrl = "http://" + Constants.SITE_DOMAIN
                    + Constants.QINIU_CALLBACK_FORAPP + bucket.getBucket()
                    + "/"; // 用于判断是否是用户上传目录
            if (userId != null && userId > 0) {
                callbackUrl += userId;
            }
        } else {
            logger.warn("QINIU_UPLOAD_TYPE_WRONG");
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


    public static Map<String, String> getProdImgUpToken2() {
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


    public static String qiniuUploadProdImg(File file) {
        String url = null;
        if (file != null && file.exists()) {
            Map<String, String> prodMap = getProdImgUpToken2();
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

}