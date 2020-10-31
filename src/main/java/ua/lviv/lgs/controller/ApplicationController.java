package ua.lviv.lgs.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		User user = new User("denys", "denys@gmail.com", "pass", UserRole.ADMIN);
		Periodical periodical = new Periodical("product", "tis nothin but a simple product", (long) 270, null);
		Bucket bucket = new Bucket(user, periodical, null);
		
		userSerivce.create(user);
		periodicalSerivce.create(periodical);
		bucketSerivce.create(bucket);
		
		return "index";
	}
	

		
	
	
}
