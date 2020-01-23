package com.khaleel.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.khaleel.model.User;
import com.khaleel.servicesImpl.UserServiceImpl;

@Controller
public class UserController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("username");
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		User user = new User();
		user.setName(name);
		user.setId(id);
		user.setEmail(email);
		System.out.println(name + "\t" + id + "\t" + email);
		UserServiceImpl usImpl = new UserServiceImpl();
		int status = usImpl.addUser(user);

		if (status == 1) {
			resp.getWriter().println("User added successfully");
		} else
			resp.getWriter().println("User not added");
	}

}
