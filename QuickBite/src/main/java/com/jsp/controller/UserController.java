package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.dao.UserDao;
import com.jsp.entity.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("user")
	public ModelAndView getUser() {
		ModelAndView m=new ModelAndView();
		User u = userDao.getUserById(1);
		m.addObject("nam", u.getName());
		m.addObject("email", u.getEmail());
		m.setViewName("index.jsp");
		return m;
	}
	@GetMapping("/create")
	public ModelAndView createUser( ) {
		ModelAndView m=new ModelAndView();
		m.addObject("user", new User());
		m.setViewName("create.jsp");
		return m;
	}
	@PostMapping("save")
	public ModelAndView getUser(User user) {
		ModelAndView m=new ModelAndView();
		userDao.saveUser(user);
		m.addObject("us", userDao.getAllUser());
		m.setViewName("view.jsp");
		return m;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		userDao.deleteUser(id);
		ModelAndView m=new ModelAndView();
		m.addObject("us", userDao.getAllUser());
		m.setViewName("view.jsp");
		return m;
	}
	@RequestMapping("/edit")
	public ModelAndView editStudent(@RequestParam int id) {
		User user = userDao.getUserById(id);
		ModelAndView m=new ModelAndView();
		m.addObject("user", user);
		m.setViewName("edit.jsp");
		return m;
	}
	@RequestMapping("/updateUser")
	public ModelAndView updateStudent(@ModelAttribute User user) {
		userDao.updateUser(user);
		List<User> allUser = userDao.getAllUser();
		ModelAndView m=new ModelAndView();
		m.addObject("us", allUser);
		m.setViewName("view.jsp");
		return m;
	}
	

}
