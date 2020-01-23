package com.khaleel.Service;

import java.util.List;

import com.khaleel.model.User;

public interface UserService {

	public int addUser(User user);
	public int deleteUser(int id);
	public int editUser(User user);
	public List<User> getAllUsers();
}
