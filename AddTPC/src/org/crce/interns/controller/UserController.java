package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserBean;
import org.crce.interns.model.User;
import org.crce.interns.service.UserService;
import org.crce.interns.validator.AddTPCValidator;
import org.crce.interns.validator.RemoveTPCValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	AddTPCValidator validator;

	@Autowired
	RemoveTPCValidator rvmvalidator;

	@RequestMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	
	@RequestMapping("/ViewUsers")
	public ModelAndView viewUsers() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("users", userService.viewUsers());
		return new ModelAndView("viewUser", modelMap);
	}

	@RequestMapping("/ViewFacultyTasks")
	public ModelAndView viewFacultyTasks() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("fusers", userService.viewFacultyTasks());
		return new ModelAndView("viewFacultyTasks", modelMap);
	}
	
	
	
	
	@RequestMapping("/InsertUser")
	public ModelAndView createUserWelcome(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("insertUser");
	}
	
	@RequestMapping("/InsertWork")
	public ModelAndView createUserWork(@ModelAttribute("command") FacultyUserBean userBean, BindingResult result) {
		return new ModelAndView("insertWork");
	}
	

	@RequestMapping("/DeleteUser")
	public ModelAndView deleteUserWelcome(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("deleteUser");
	}

	@RequestMapping(value = "/SubmitInsertUser", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("command") UserBean userBean, BindingResult bindingResult) {
		validator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("insertUser");
		}
		int a;
		a=userService.insertUser(userBean);
		FacultyUserBean fuserBean= new FacultyUserBean();
		fuserBean.setUsername(userBean.getUsername());
	/*	System.out.println(userBean.getUserName()+" in Contoller");
		System.out.println(userBean.getUserRole()+" in Contoller");*/
		if(userBean.getRole_id().equalsIgnoreCase("2")&& (a==1))
		{
			System.out.println("\n\n\n"+fuserBean.getUsername()+" in Contoller");
			//userService.insertWork(fuserBean);
			return new ModelAndView("redirect:/InsertWork");
		}
		else
		return new ModelAndView("redirect:/ViewUsers");
	}
	
	
	
	
	@RequestMapping(value = "/SubmitInsertWork", method = RequestMethod.POST)
	public ModelAndView createWork(@ModelAttribute("command") FacultyUserBean fuserBean, BindingResult bindingResult) {
		/*validator.validate(fuserBean, bindingResult);*/
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("insertWork");
		}
		System.out.println("Username in Controller :"+fuserBean.getUsername());
		userService.insertWork(fuserBean);
		/*System.out.println(fuserBean.getUserName()+" in Contoller");
		System.out.println(fuserBean.getUserWork()+" in Contoller");*/
		
		return new ModelAndView("redirect:/ViewFacultyTasks");
	}
		
	
	@RequestMapping(name = "/SubmitDeleteUser", method = RequestMethod.POST)
	public ModelAndView deleteUser(@ModelAttribute("command") UserBean userBean, BindingResult bindingResult) {
		rvmvalidator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("deleteUser");
		}
		userService.deleteUser(userBean);
		return new ModelAndView("redirect:/ViewUsers");
	}

}
