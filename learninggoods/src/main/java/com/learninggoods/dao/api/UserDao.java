package com.learninggoods.dao.api;

import java.util.List;

import com.learninggoods.dao.entity.User;

public interface UserDao {
	
	public boolean insert(User user);
	public List<User> getAllUser();
	public boolean delete(String userId);
	public boolean update(User user);
	public User getUserByEmail(String email);
	
}
