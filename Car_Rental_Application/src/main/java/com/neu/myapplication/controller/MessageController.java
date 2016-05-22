package com.neu.myapplication.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myapplication.dao.CarDAO;
import com.neu.myapplication.dao.MessageDAO;
import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.Message;
import com.neu.myapplication.pojo.User;

@Controller
public class MessageController {
	
	@RequestMapping(value="/sendRequest.htm", method = RequestMethod.POST)
	public ModelAndView sendMessage(HttpServletRequest request1) throws Exception{
		try {
			MessageDAO messageDao = new MessageDAO();
			User user=(User) request1.getSession().getAttribute("user");
			messageDao.saveMessage(user);
			request1.getSession().setAttribute("messageStatus", "sent");
		} 
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		String msg = "Your request has been sent and it is waiting for admin approval!! Once it is approved you'll get a link for booking!!";
		ModelAndView mv = new ModelAndView("register", "messageSent", msg);
		return mv;
	}
	
	@RequestMapping(value="/getMessages.htm", method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MessageDAO messages = null;
        List<Message> getMessageList = null;      
        List<Message> messageList = new ArrayList();
        

        try {
            messages = new MessageDAO();
            getMessageList = messages.getMessageList();

            for(Message m: getMessageList){
            	messageList.add(m);
            }
            //DAO.close();
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("viewMessages", "messageList", messageList);
        return mv;
    }
	
	@RequestMapping(value="/acceptRequest.htm", method = RequestMethod.POST)
	public ModelAndView approveRequest(@ModelAttribute("message") Message message, HttpServletRequest request1) throws Exception{
		try {
			System.out.println("inside send message");
			
			MessageDAO messageDao = new MessageDAO();
			User user=(User) request1.getSession().getAttribute("user");
			Message m = (Message) request1.getSession().getAttribute("message");
			
			int updateResult = messageDao.approveRequest(m);
			if(updateResult ==1){
				request1.getSession().setAttribute("messageStatus", "approved");
			}
			else{
				request1.getSession().setAttribute("messageStatus", "sent");
			}
		} 
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		String msg = "Your request has been sent";
		ModelAndView mv = new ModelAndView("register", "messageSent", msg);
		return mv;
	}

}
