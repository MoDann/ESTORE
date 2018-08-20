package com.briup.estore.common.util;

import java.security.MessageDigest;



import sun.misc.BASE64Encoder;


/**
 * 加密算法类
 * 
 * @author ASUS
 * @date 2018-7-30
 */
@SuppressWarnings("restriction")
public class UtilMD5 {
	
	public static String getMd5(String message){
		 try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] bs = md.digest(message.getBytes());
			return new BASE64Encoder().encode(bs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	 }
}
