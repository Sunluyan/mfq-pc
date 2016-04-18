package com.mfq.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;



public class AliyunFile {
	private static String accessKeyId="5xWxi1cU1RDlB04J";
	private static String accessKeySecret="u05BnJUOXIwut5XhPznFN72uvnTBXx";
	private static String endpointExternal="http://oss-cn-beijing.aliyuncs.com";//外网使用
	private static String endpointInternal="http://oss-cn-beijing-internal.aliyuncs.com";//内网使用
	private static OSSClient client;
	//private static String bucketName ="yeeda";
	
	private static  OSSClient  getClient(){
		if(client==null){
			ClientConfiguration conf = new ClientConfiguration();
			conf.setMaxConnections(10);
			conf.setConnectionTimeout(10000);
			conf.setMaxErrorRetry(2);
			conf.setSocketTimeout(10000);
			
			client = new OSSClient( endpointExternal,accessKeyId, accessKeySecret,conf);
		}
		return client;
	}

	public static boolean  uploadFile(String bucketName,File source,String newFilename){
		try{
			
			FileInputStream fis= new FileInputStream(source);    
		    String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));    
		    IOUtils.closeQuietly(fis);
		    
			
			InputStream is=new FileInputStream(source);
			ObjectMetadata meta = new ObjectMetadata(); // �������� ContentLength meta.setContentLength(file.length());
			meta.setContentLength(source.length());
			
			PutObjectResult result = getClient().putObject(bucketName, newFilename, is, meta);
			
			if(result.getETag().toLowerCase().equals(md5)){
				return true;				
			}
			else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}
	

	

	
	public static boolean downloadFile(String bucketName,String filename,File file){
		try{
			ObjectMetadata object = getClient().getObject(new GetObjectRequest(bucketName, filename),file);			
			return true;
		}catch(Exception e){
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static InputStream downloadFile(String bucketName ,String filename){
		try{
			OSSObject  object=getClient().getObject(bucketName, filename);
			if(object==null){
				return null;
			}
			else{
				return object.getObjectContent();
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static boolean copyFile(String sourceBucketName,String sourceFileName,String distBucketName,String disFileName){
		try{
			getClient().copyObject(sourceBucketName, sourceFileName, distBucketName, disFileName);
			deleteFile(sourceBucketName,sourceFileName);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static void deleteFile(String bucketName,String filename){
		try{
			if(filename!=null){
				getClient().deleteObject(bucketName, filename);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
}
