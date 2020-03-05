package com.example.demo4.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Description  
 * <p>Date: Mon Sep 02 17:02:28 CST 2019.</p>
 *
 * @author C3006018
 */

@Data
public class UserInfo {

	 // 工號
	private String userNo;
	 // 姓名
	private String userName;
	 // 單位代碼
	private String userExpcode;
	 // 密碼
	private String userPwd;
	 // 廠區
	private String factoryno;
	 // 組別
	private String categories;
	 // 是否有效,0無效，1有效
	private Integer isvalid;
	 // 電話
	private String tel;
	 // 創建時間
	private Date createtime;
	 // 權限，逗號隔開
	private String powerId;
	//產品處
	private String punit;


}
