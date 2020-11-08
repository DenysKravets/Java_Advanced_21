package ua.lviv.lgs.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Periodical;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.dto.PeriodicalDto;
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
	
	//Periodical
	@RequestMapping(value = "/periodical", method = RequestMethod.GET)
	public String periodical(HttpServletRequest request) {
		
		request.setAttribute("periodical", new Periodical());
		
		return "addPeriodical";
	}

	@RequestMapping(value = "/periodical", method = RequestMethod.POST)
	public ModelAndView periodicalPost(@ModelAttribute("periodical") Periodical periodical, @RequestPart("file") MultipartFile file) throws IOException {
		
		periodicalSerivce.create(periodical);
		
		return new ModelAndView("redirect:/periodical");
	}
	
	@RequestMapping(value = "/showPeriodicals", method = RequestMethod.GET)
	public String showPeriodicals(HttpServletRequest request) {
		
		Iterator<Periodical> periodicals = periodicalSerivce.readAll().iterator();
		
		List<PeriodicalDto> periodicalDtos = new ArrayList<>();
		
		while(periodicals.hasNext()) {
			
			Periodical periodical = periodicals.next();
			PeriodicalDto periodicalDto = new PeriodicalDto();
			
			periodicalDto.id = periodical.getId();
			periodicalDto.name = periodical.getName();
			periodicalDto.description = periodical.getDescription();
			periodicalDto.price = periodical.getPrice();
			periodicalDto.photo = Base64.getEncoder().encodeToString(periodical.getPhoto());
			
			periodicalDtos.add(periodicalDto);
		}
		
		request.setAttribute("periodicals", periodicalDtos);
		
		return "showPeriodicals";
	}
	
	//Bucket
	@Transactional(readOnly = true)
	@RequestMapping(value = "/showBucket", method = RequestMethod.GET)
	public String showBucket(HttpServletRequest request, Principal principal) {
		
		User user = userSerivce.readByEmail(principal.getName());
		Stream<Bucket> bucketStream = bucketSerivce.readByUser(user);
		List<PeriodicalDto> periodicalDtos = new ArrayList<>();
		
		bucketStream.forEach(bucket -> {
			Periodical periodical = bucket.getPeriodical();
			
			PeriodicalDto periodicalDto = new PeriodicalDto();
			
			periodicalDto.id = bucket.getId();
			periodicalDto.name = periodical.getName();
			periodicalDto.description = periodical.getDescription();
			periodicalDto.price = periodical.getPrice();
			periodicalDto.photo = Base64.getEncoder().encodeToString(periodical.getPhoto());
			
			periodicalDtos.add(periodicalDto);
		});
		
		request.setAttribute("periodicals", periodicalDtos);
		
		return "showBucket";
	}
	
	@RequestMapping(value = "/addPeriodicalToBucket", method = RequestMethod.GET)
	public ModelAndView addPeriodicalToBucket(@RequestParam long id, Principal principal) throws IOException {
		
		System.out.println(id);
		
		User user = userSerivce.readByEmail(principal.getName());
		Periodical periodical = periodicalSerivce.read(id);
		Bucket bucket = new Bucket(user, periodical, new Date(System.currentTimeMillis()));
		bucketSerivce.create(bucket);
		
		return new ModelAndView("redirect:/showPeriodicals");
	}
	
	@RequestMapping(value = "/removePeriodicalFromBucket", method = RequestMethod.GET)
	public ModelAndView removePeriodicalfromBucket(@RequestParam long id) throws IOException {
		
		Bucket bucket = bucketSerivce.read(id);
		bucketSerivce.delete(bucket);
		
		return new ModelAndView("redirect:/showPeriodicals");
	}
	
}
