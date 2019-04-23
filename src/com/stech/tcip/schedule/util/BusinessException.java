package com.stech.tcip.schedule.util;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 8109303352556055331L;

	private String message;
	
	private String title;

	public BusinessException(String title, String message) {
		super(message);
		super.printStackTrace();
		this.message = message;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}