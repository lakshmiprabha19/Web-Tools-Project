package com.neu.myapplication.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myapplication.dao.MessageDAO;
import com.neu.myapplication.dao.UserDAO;
import com.neu.myapplication.pojo.User;
import com.neu.myapplication.validator.LoginValidator;
import com.neu.myapplication.validator.UserValidator;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("loginValidator")
	LoginValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/login.htm", method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultString = null;
		ModelAndView mv=null;
		String msg;
		if (result.hasErrors()) {
			msg = "Form has errors";
			mv = new ModelAndView("index", "msg", msg);
		}
		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");
			
			User checkUser = userDao.checkUser(user);
			if(checkUser!=null){
				request.getSession().setAttribute("user", checkUser);
				if(checkUser.getRole().equals("admin")){
					msg = "";
					//Create Cookie
	                Cookie userCookie = new Cookie("userName", user.getUsername());
	                Cookie passwordCookie = new Cookie("password", user.getPassword());
	                response.addCookie(userCookie);
	                response.addCookie(passwordCookie);
					mv = new ModelAndView("redirect:/addCar.htm", "msg", msg);
				}
				else{
					msg = "";
					//Create Cookie
	                Cookie userCookie = new Cookie("userName", user.getUsername());
	                Cookie passwordCookie = new Cookie("password", user.getPassword());
	                response.addCookie(userCookie);
	                response.addCookie(passwordCookie);
					mv = new ModelAndView("register", "msg", msg);
				}
				
			}
			else{
				System.out.println("else checkUser");
				msg = "User does not exist";
				mv = new ModelAndView("index", "msg", msg);
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return mv;		
	}
	
	@RequestMapping(value="/login.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result1) {
		System.out.println("inside method");
		return "index";
	}
	
	@RequestMapping(value="/logout.htm", method = RequestMethod.GET)
	protected String doLogout(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
	    return "redirect:/login.htm";
	}
	
	@RequestMapping(value="/register.htm", method = RequestMethod.GET)
	public String initialize(@ModelAttribute("user") User user, BindingResult result1) {
		return "register";
	}
}
