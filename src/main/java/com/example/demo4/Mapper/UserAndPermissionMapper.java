package com.example.demo4.Mapper;


import com.example.demo4.dto.UserInfo;
import com.example.demo4.dto.UserRoleDTO;

import java.util.List;

public interface UserAndPermissionMapper {

	//查詢所有用戶(根據廠區/產品處)
	List<UserInfo> selectUserList(String factoryNo, String punit);

	//查询該用戶的所有權限
	List<UserRoleDTO> getUserRoles(String userId);

	//獲取當前用戶信息(根據工號)
	UserInfo getCurrentUserInfoByWorkId(String userId);
}

