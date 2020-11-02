package ua.lviv.lgs.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Periodical;
import ua.lviv.lgs.domain.User;

import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.serviceImpl.BucketServiceImpl;
import ua.lviv.lgs.serviceImpl.PeriodicalServiceImpl;
import ua.lviv.lgs.serviceImpl.UserServiceImpl;

@Controller
public class ApplicationController  {
	
	@Autowired
	private UserServiceImpl userSerivce;
	
	@Autowired
	private PeriodicalServiceImpl periodicalSerivce;
	
	@Autowired
	private BucketServiceImpl bucketSerivce;

	//Start
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start(HttpServletRequest request) {
		
		return "index";
	}
	
	//Login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	//Register
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(HttpServletRequest request) {
		
		User user = new User();
		
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setRole(UserRole.valueOf(request.getParameter("role")));
		
		userSerivce.create(user);
		
		return "login";
	}
	
	//Administrator
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		
		return "admin";
	}
	
	//User
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		
		return "user";
	}
	

		
	
	
}
