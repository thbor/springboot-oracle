package com.example.demo4.service.serviceImpl;

import com.example.demo4.Mapper.UserAndPermissionMapper;
import com.example.demo4.dto.UserInfo;
import com.example.demo4.service.UserAndPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserAndPermissionServiceImpl implements UserAndPermissionService {

	@Autowired
	private UserAndPermissionMapper userAndPermissionMapper;

	/**
	 * 獲取當前用戶信息
	 * @param userId 工號
	 * @return
	 */
	public UserInfo getCurrentUserInfoByWorkId(String userId){
		return userAndPermissionMapper.getCurrentUserInfoByWorkId(userId);
	}



}
