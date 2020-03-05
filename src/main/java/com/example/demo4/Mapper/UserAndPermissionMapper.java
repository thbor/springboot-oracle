package com.example.demo4.Mapper;


import com.example.demo4.dto.UserInfo;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface UserAndPermissionMapper {

	//獲取當前用戶信息(根據工號)
	UserInfo getCurrentUserInfoByWorkId(String userId);
}

