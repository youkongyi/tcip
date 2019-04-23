package com.stech.tcip.sys.enums;

/**
 * 
 * @ClassName:  PushCodeEnum   
 * @Description:TODO(消息推送事件枚举)   
 * @author: samuel 
 * @date:   2017年8月10日 上午11:55:23   
 *   
 *
 */
public enum PushCodeEnum {
	NEWBILL("4003", "新账单"),
	ORDERCHANGE("4004", "工单状态变更"),
	OVERDUE("4005", "账单超期"),
	SENDWITHHOLD("4006", "银行代扣送扣信息"),
	WITHHOLDCHANGE("4007", "银行代扣回盘信息"),
	GSSELLORDER("4008", "燃气具销售订单信息");

	// 成员变量
	private String code;
	private String name;

	private PushCodeEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	/**
	 * 
	 * @Title: contains   
	 * @Description: TODO(判断枚举类是否包含该编码)   
	 * @param code
	 * @return:boolean
	 */
	public static boolean contains(String code){
		boolean containFlag = false; 
		for (PushCodeEnum codeEnum :PushCodeEnum.values()){
			if (codeEnum.getCode().equals(code)){
				containFlag = true;
				break;
			}
		}
		return containFlag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
