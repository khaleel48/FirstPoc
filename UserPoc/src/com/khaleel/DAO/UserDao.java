package com.khaleel.DAO;

import java.util.List;

import com.khaleel.model.User;

public interface UserDao {

	public int saveUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id);
	public User getUserDataByID(int id);
	public List<User> allUsers();
	
	
}
