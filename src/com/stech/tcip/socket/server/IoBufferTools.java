package com.stech.tcip.socket.server;

import java.io.UnsupportedEncodingException;
import org.apache.mina.core.buffer.IoBuffer;

public class IoBufferTools {

    private static String CHARSET = "GB2312";
    
	public static IoBuffer create(String s) {
		try {
			byte[] bytes = s.getBytes(CHARSET);
			int len = bytes.length;
			IoBuffer buffer = IoBuffer.allocate(len);
			buffer.put(bytes);
			buffer.flip();
			return buffer;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
