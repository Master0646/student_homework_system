package com.tujietg.gradpro.service.Impl;

import com.tujietg.gradpro.dao.UserDao;
import com.tujietg.gradpro.pojo.User;
import com.tujietg.gradpro.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by tujietg on Apr 2019.
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public String getPasswd(String username) {
		return userDao.getPasswd(username);
	}

	@Override
	public String getPasswdById(String uid) {
		return userDao.getPasswdById(uid);
	}

	@Override
	public boolean isFirstLogin(String uid) {
		return userDao.isFirstLogin(uid);
	}

	@Override
	public User getUserEntity(String username) {
		return userDao.getUserEntity(username);
	}

	@Override
	public void setUserPasswd(Map<String, String> map) {
		userDao.setUserPasswd(map);
	}

	@Override
	public void setFirstLogin(Map<String, Object> firstLogin) {
		userDao.setFirstLogin(firstLogin);
	}

	@Override
	public User getUserEntityByID(String uid) {
		return userDao.getUserEntityByID(uid);
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public User getUserEntityByOpenID(String userOpenID) {
		return userDao.getUserEntityByOpenID(userOpenID);
	}

	@Override
	public void insertQQIDByUID(User user) {
		userDao.insertQQIDByUID(user);
	}

}
