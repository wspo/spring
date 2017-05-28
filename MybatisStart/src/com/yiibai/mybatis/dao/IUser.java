package com.yiibai.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yiibai.mybatis.models.User;

public interface IUser {
	@Select("select * from user where id= #{id}")
	public User getUserByID(int id);

	public List<User> getUserList();

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(int userId);

	public User getUser(int id);
}
