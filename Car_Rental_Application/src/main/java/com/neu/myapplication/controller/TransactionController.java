package com.neu.myapplication.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myapplication.dao.CarDAO;
import com.neu.myapplication.dao.TransactionDAO;
import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.Transaction;
import com.neu.myapplication.pojo.User;

@Controller
public class TransactionController {
	@RequestMapping(value="/createTransaction.htm", method=RequestMethod.POST)
	protected String handleRequestInternal(@ModelAttribute("transaction") Transaction transaction1, BindingResult result1, HttpServletRequest request1, HttpServletResponse response1) throws Exception {
		System.out.println("inside transaction controller");
		return "redirect:/saveTransaction.htm";       
    }
	
	@RequestMapping(value="/createTransaction.htm", method = RequestMethod.GET)
	public String initializeSignUpForm(@ModelAttribute("transaction") Transaction transaction, BindingResult result) {

		return "amount";
	}
	
	@RequestMapping(value="/saveTransaction.htm", method = RequestMethod.GET)
	public String initializeForm1(@ModelAttribute("transaction") Transaction transaction, BindingResult result) {

		return "transaction";
	}
	
	@RequestMapping(value="/saveTransaction.htm", method = RequestMethod.POST)
	public String initializeForm(@ModelAttribute("transaction") Transaction transaction, BindingResult result, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			System.out.print("test");
			TransactionDAO transactionDao = new TransactionDAO();
			System.out.print("test1");
			User u = (User) session.getAttribute("user");
			Transaction t = transactionDao.addTransaction(transaction, u);
			session.setAttribute("transaction", t);
			System.out.println("inssss car"+t);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "transactionComplete";
	}
}
