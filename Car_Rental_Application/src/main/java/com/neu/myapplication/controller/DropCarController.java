package com.neu.myapplication.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myapplication.dao.CarDAO;
import com.neu.myapplication.dao.ReservationDAO;
import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.Reservation;
import com.neu.myapplication.pojo.User;

@Controller
public class DropCarController {
	@RequestMapping(value="/dropCar.htm", method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("reservation") Reservation reservation, BindingResult result, HttpServletRequest request) throws AdException {
		HttpSession session = request.getSession();
		Reservation r = null;
		try {
        ReservationDAO reserve = new ReservationDAO();
        User user1 = (User) session.getAttribute("user");
        r = reserve.getReservationData(user1);
        if(r!=null){
	        CarDAO cardao = new CarDAO();
	        Car c = cardao.getCarFromReservation(r.getCarId());
	        request.setAttribute("carReservation", c);
        }
        else{
        	request.setAttribute("errormsg", "You have not reserved a car yet!!!!");
        }
	}catch (AdException e) {
        System.out.println(e.getMessage());
    }
		ModelAndView mv = new ModelAndView("dropReservation", "reser", r);
		return mv;	
	}
	
	@RequestMapping(value="/dropCarReservation.htm", method = RequestMethod.POST)
	public String bookReservation(@ModelAttribute("reservation") Reservation reservation, BindingResult result, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Reservation r = null;
		String msg = null;
		try {			
			User user=(User) session.getAttribute("user");
			ReservationDAO reservationDao = new ReservationDAO();
			int r_id = (Integer) session.getAttribute("r_id");
			r = reservationDao.updateDropDetails(reservation, r_id);
			long hoursUsed = reservationDao.calculateHoursUsed(r);
			double amount = reservationDao.calculateAmount(hoursUsed);
			double totalAmount = reservationDao.calculateTotalAmount(amount);
			session.setAttribute("hours", hoursUsed);
			session.setAttribute("amount", amount);
			session.setAttribute("totalAmount", totalAmount);
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }
		return "redirect:/createTransaction.htm";
	}
}
