package com.example.demo4.vo;

import lombok.Data;

@Data
public class MessageInfo {
	/**
	 * 状态码
	 */
	private String code;
	/**
	 * 消息
	 */
	private String msg;
	/**
	 * 消息
	 */
	private Object data;

	private String type;
	public MessageInfo(){}
	public MessageInfo(String code, String msg, Object data) {
		this.code=code;
		this.msg=msg;
		this.data=data;
	}

	public MessageInfo(String code, String msg) {
		this.code=code;
		this.msg=msg;
	}
}
