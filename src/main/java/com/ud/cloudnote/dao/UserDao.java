package com.ud.cloudnote.dao;

import java.util.Map;

import com.ud.cloudnote.entity.User;

public interface UserDao {
	public void save(User user);
	public User findByName(String name);
	public User findById(String userId);
	public int changePassword(Map<String,String> param);
}
