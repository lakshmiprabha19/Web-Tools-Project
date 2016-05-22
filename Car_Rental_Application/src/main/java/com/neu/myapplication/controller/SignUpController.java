package com.neu.myapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myapplication.dao.UserDAO;
import com.neu.myapplication.pojo.User;
import com.neu.myapplication.validator.UserValidator;

@Controller
public class SignUpController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/signUp.htm", method = RequestMethod.GET)
	public String initializeSignUpForm(@ModelAttribute("user") User user, BindingResult result) {

		return "signUp";
	}
	
	@RequestMapping(value="/signUp.htm", method = RequestMethod.POST)
	protected ModelAndView handleSignUp(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		validator.validate(user, result);
		String view = null;
		ModelAndView mv = null;
		if (result.hasErrors()) {
			System.out.println("inside errors");
			String msg = "Errors!!!!!!!!!!";
			mv = new ModelAndView("signUp", "user1", msg);
	        return mv;
		}

		try {
			UserDAO userDao = new UserDAO();

			boolean f = userDao.create(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getDob());
			if(f){	
				String msg = "User created!!!!";
				mv = new ModelAndView("index", "user1", msg);
			}
			else {
				String msg = "User already exists!!!!";
				mv = new ModelAndView("signUp", "user1", msg);			
			}
			
			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return mv;

		
	}
}
