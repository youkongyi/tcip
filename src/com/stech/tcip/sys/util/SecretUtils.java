package com.stech.tcip.sys.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SecretUtils {

	public static String encryptDESCBC(String src,String key) throws Exception{
		// --生成key,同时制定是des还是DESede,两者的key长度要求不同
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
		
		//加密向量
		IvParameterSpec iv = new IvParameterSpec(Constants.SECRET_IV.getBytes("UTF-8"));
		
		// --通过Chipher执行加密得到的是一个byte的数组,Cipher.getInstance("DES")就是采用ECB模式,cipher.init(Cipher.ENCRYPT_MODE,
        // secretKey)就可以了.
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey,iv);
		byte[] b = cipher.doFinal(src.getBytes("UTF-8"));
		
		  // --通过base64,将加密数组转换成字符串
        final BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b);
	}
	
	// 3DESECB加密,key必须是长度大于等于 3*8 = 24 位
    public static String encryptThreeDESECB(final String src, final String key) throws Exception {
        final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        final SecretKey securekey = keyFactory.generateSecret(dks);

        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, securekey);
        final byte[] b = cipher.doFinal(src.getBytes());

        final BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b).replaceAll("\r", "").replaceAll("\n", "");

    }

    // 3DESECB解密,key必须是长度大于等于 3*8 = 24 位
    public static String decryptThreeDESECB(final String src, final String key) throws Exception {
        // --通过base64,将字符串转成byte数组
        final BASE64Decoder decoder = new BASE64Decoder();
        final byte[] bytesrc = decoder.decodeBuffer(src);
        // --解密的key
        final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        final SecretKey securekey = keyFactory.generateSecret(dks);

        // --Chipher对象解密
        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, securekey);
        final byte[] retByte = cipher.doFinal(bytesrc);

        return new String(retByte);
    }
	
	
	public static void main(String[] args) {
		try {
			System.out.println(SecretUtils.encryptThreeDESECB("1234567", "")); 
			System.out.println(SecretUtils.decryptThreeDESECB("zCli2EIPB90=",  "")); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
