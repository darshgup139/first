package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@RequestMapping("/InsertUser")
	public ModelAndView createUserWelcome(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("insertUser");
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

		userService.insertUser(userBean);
		return new ModelAndView("redirect:/ViewUsers");
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
