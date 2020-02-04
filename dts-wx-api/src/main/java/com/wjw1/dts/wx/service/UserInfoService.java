package com.wjw1.dts.wx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wjw1.dts.db.domain.DtsUser;
import com.wjw1.dts.db.service.DtsUserService;
import com.wjw1.dts.wx.dao.UserInfo;

@Service
public class UserInfoService {
	@Autowired
	private DtsUserService userService;

	public UserInfo getInfo(Integer userId) {
		DtsUser user = userService.findById(userId);
		Assert.state(user != null, "用户不存在");
		UserInfo userInfo = new UserInfo();
		userInfo.setNickName(user.getNickname());
		userInfo.setAvatarUrl(user.getAvatar());
		return userInfo;
	}
}
