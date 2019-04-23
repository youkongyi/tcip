package com.stech.tcip.sys.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.sys.pojo.RequestInfo;

/**
 * 
 * @ClassName:  Utils   
 * @Description:TODO(工具类)   
 * @author: samuel 
 * @date:   2017年7月10日 上午10:41:37   
 *
 */
@Component
public class Utils {
	
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 
	 * @Title: ObectToJson   
	 * @Description: TODO(将普通java对象转换为json字符串)   
	 * @param obj
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public static String ObectToJson(Object obj) throws JsonProcessingException{
		try {
			mapper.setSerializationInclusion(Inclusion.NON_NULL);
			mapper.setSerializationInclusion(Inclusion.NON_EMPTY);
			mapper.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);
			return mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 
	 * @Title: postJosnParam   
	 * @Description: TODO(处理post请求的json字符串)   
	 * @param head
	 * @param body
	 * @return:String
	 * @throws JsonProcessingException 
	 */
	public static String postJosnParam(RequestInfo requestInfo,String body) throws JsonProcessingException{
		
		requestInfo.setRequestid(null);
		
		String head = ObectToJson(requestInfo);
		String strjson = head.substring(0, head.length()-1)+ "," + body.trim().substring(1);
		return strjson;
	}
	
	/**
	 * 
	 * 
	 * @Title: postJosnParamForQuery   
	 * @Description: TODO(处理post请求的json对象)   
	 * @param head
	 * @param body
	 * @return:String
	 * @throws JsonProcessingException 
	 */
	public static String postJosnParamForQuery(RequestInfo requestInfo,String body) throws JsonProcessingException{
		
		String head = ObectToJson(requestInfo);
		String strjson = head.substring(0, head.length()-1)+ ",\"body\":" + body.trim() + "}";
		return strjson;
	}
	
	
	public static void main(String[] args) {
		int actState = 0;
		int tmp = 1; 
		
		
		System.out.println(Integer.toBinaryString((actState |= tmp<<0)));
		System.out.println(Integer.toBinaryString((actState |= tmp<<1)));
		System.out.println(Integer.toBinaryString((actState |= tmp<<2)));
		System.out.println(Integer.toBinaryString((actState |= tmp<<3)));
		
		//tmp = tmp << 2;
		//System.out.println(Integer.toBinaryString(actState &= ~tmp));
		
		
		System.out.println(Integer.toBinaryString(actState & tmp));
		
	}
}
