package com.stech.tcip.sys.util;

import sun.misc.BASE64Encoder;

/**
 * 
 * 
 * @ClassName: Constants
 * @Description:TODO(常量类)
 * @author: samuel
 * @date: 2017年7月10日 上午11:22:29
 * 
 *
 */
public class Constants {

	public static final String TOKEN_OPERATOR = "TCIS";

	// 错误码：0 请求成功!
	public static final String ERR_CODE_SUCCESS = "0";

	// 非法的TOKEN
	public static final String ERR_CODE_UNLAWFULTOKEN = "4000";

	// 非法的TOKEN
	public static final String ERR_CODE_UNLAWFULSERVICE = "4007";

	// 加密算子
	public static final String SECRET_IV = "1@aBC952";

	public static final String SECRET_KEY = "1234567890QWERTYUIOPLKJHGFDSAZXCVBNM";

	public static final String SECRET_PUB_KEY = "$qwertyuiopASDFGHJKL1234567809@!";

	// 推送新账单提醒
	public static final String TCIS_PUSH_NEWBILL = "4003";
	// 推送超期提醒
	public static final String TCIS_PUSH_OVERDUE = "4004";
	// 推送工单状态变更
	public static final String TCIS_PUSH_ORDERCHANGE = "4005";
	// 推送送扣信息
	public static final String TCIS_PUSH_SENDWITHHOLD = "4006";
	// 推送回盘信息
	public static final String TCIS_PUSH_WITHHOLDCHANGE = "4007";

	// gssellorder
	// 推送回盘信息
	public static final String TCIS_PUSH_GSSELLORDER = "4008";

	// 系统编码
	public static final String ENCODING_UTF8 = "UTF-8";

	public static void main(String[] args) {
		BASE64Encoder encoder = new BASE64Encoder();

		System.out.println(encoder.encode("MVZFTkpVMVpyVGtSUlJFVXlUWGsxYW1JeU1XWlhiRTEzVFZSQk1WaDZSWGhOZWtGNVdERk9TbEl3 TlZaVmExVTk=".getBytes()));
	}
}
