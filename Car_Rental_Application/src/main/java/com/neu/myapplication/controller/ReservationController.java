package com.neu.myapplication.controller;

import java.util.Date;

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
import com.neu.myapplication.dao.UserDAO;
import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.Reservation;
import com.neu.myapplication.pojo.User;

@Controller
public class ReservationController {
	@RequestMapping(value="/addReservation.htm", method = RequestMethod.POST)
	public ModelAndView navigate(@ModelAttribute("reservation") Reservation reservation, BindingResult result, HttpServletRequest request) throws AdException {
		HttpSession session = request.getSession();
		Car car = null;
		try {
			int carId = (Integer)session.getAttribute("carid");
	        CarDAO carDao = new CarDAO();
        	System.out.println("inside reservation");
        	car = carDao.getCar(carId);
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }
		ModelAndView mv = new ModelAndView("reservation", "cars", car);
		return mv;
		//DAO.close();
	}
	
	
	@RequestMapping(value="/bookReservation.htm", method = RequestMethod.POST)
	public ModelAndView addReservation(@ModelAttribute("reservation") Reservation reservation, BindingResult result, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Reservation reservationItem = null;
		try {
			System.out.print("test");
			int carid = (Integer)session.getAttribute("carid");
			CarDAO carDao = new CarDAO();
			Car car = carDao.getCar(carid);
			User user=(User) session.getAttribute("user");
			ReservationDAO reservationDao = new ReservationDAO();
			UserDAO userDAO = new UserDAO();
			System.out.print("test1");
			Date date1 = userDAO.getDateOfBirth(reservation.getPickupdate());
			reservationItem = reservationDao.addReservation(reservation.getPicklocation(), reservation.getDroplocation(), reservation.getStatus(), date1, reservation.getPickuptime(), reservation.getPickuptimeName(), reservation.getHours(), car, user);
			System.out.println("inssss car"+reservationItem);
		
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }
		ModelAndView mv = new ModelAndView("reservationComplete", "res", reservationItem);
		return mv;
	}
}
