package com.khaleel.servicesImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.khaleel.DAO.UserDaoImpl;
import com.khaleel.Service.UserService;
import com.khaleel.model.User;

@Service
@PropertySource("classpath:app.properties")
public class UserServiceImpl implements UserService {
	
	
	UserDaoImpl userDao=new UserDaoImpl();
	@Override
	public int addUser(User user) {
		return userDao.saveUser(user);
	}

	
	@Override
	public int deleteUser(int id) {
		
		return userDao.deleteUser(id);
	}

	@Override
	public int editUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.allUsers();
	}

	

	
	
	
}
