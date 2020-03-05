package com.example.demo4.service;

import com.example.demo4.dto.UserInfo;
import com.example.demo4.dto.UserRoleDTO;

import java.util.List;
import java.util.Map;

public interface UserAndPermissionService {

	Map<String, Object> qryUserList(String factoryNo, String punit);

	List<UserRoleDTO> getUserRoles(String userId);

	UserInfo getCurrentUserInfoByWorkId(String userId);



}
