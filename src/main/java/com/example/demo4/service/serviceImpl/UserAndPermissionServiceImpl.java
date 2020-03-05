package com.example.demo4.service.serviceImpl;

import com.example.demo4.Mapper.UserAndPermissionMapper;
import com.example.demo4.dto.UserInfo;
import com.example.demo4.dto.UserRoleDTO;
import com.example.demo4.service.UserAndPermissionService;
import com.example.demo4.utils.MsgKits;
import com.example.demo4.utils.StatusConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserAndPermissionServiceImpl implements UserAndPermissionService {

	@Autowired
	private UserAndPermissionMapper userAndPermissionMapper;
	
	/**
	 * 获取用户信息列表(根據廠區/產品處)
	 * @param punit 
	 * @param factoryNo
	 */
	@Override
	public Map<String, Object> qryUserList(String factoryNo, String punit) {
		List<UserInfo> userList = userAndPermissionMapper.selectUserList(factoryNo,punit);
		return MsgKits.replyMap(StatusConstants.SUCCESS, "OK", StatusConstants.TYPE_USER, userList);
	}

	/**
	 *獲得
	 * @param userId (工號）
	 * @return list 包含 USER_ID; //工號
	 *      POWER_ID;//權限ID
	 *     POWER_ROLE;//權限   eg： 換刀申請，超級管理員
	 */
	@Override
	public List<UserRoleDTO> getUserRoles(String userId){
		return userAndPermissionMapper.getUserRoles(userId);
	}

	/**
	 * 獲取當前用戶信息
	 * @param userId 工號
	 * @return
	 */
	public UserInfo getCurrentUserInfoByWorkId(String userId){
		return userAndPermissionMapper.getCurrentUserInfoByWorkId(userId);
	}



}
