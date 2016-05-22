package com.neu.myapplication.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.SysexMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myapplication.dao.CarDAO;
import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.Reservation;
import com.neu.myapplication.pojo.User;

@Controller
public class BookCarController {
	
	@RequestMapping(value="/bookCar.htm", method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("car") Car car, BindingResult result) {
        CarDAO cars = null;
        List<Car> retrieveList = null;
        List<Car> carList = new ArrayList();

        try {
            cars = new CarDAO();
            retrieveList = cars.getCarList();

            for(Car c: retrieveList){
            	carList.add(c);
            }
            //DAO.close();
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("bookCars", "carList", carList);
        return mv;
	}
	
	@RequestMapping(value="/selectCar.htm", method = RequestMethod.POST)
	public void handleRequest(HttpServletRequest request) throws AdException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		Car car=null;
		try {
			int carId = Integer.parseInt(request.getParameter("carId"));
	        CarDAO carDao = new CarDAO();
	        if(action.equals("carbooking")){
	        	car = carDao.getCar(carId);
	        	session.setAttribute("carObject", car);
	        }
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }
		
		    
	}
	@RequestMapping(value="/showReservation.htm", method = RequestMethod.POST)
	public ModelAndView navigate(@ModelAttribute("reservation") Reservation reservation, BindingResult result, HttpServletRequest request) throws AdException {
		HttpSession session = request.getSession();
		Car car = null;
		car = (Car) session.getAttribute("carObject");
		User u = (User) session.getAttribute("user");
		CarDAO carDAO = new CarDAO();
		ModelAndView mv = new ModelAndView("reservation", "cars", car);
		return mv;
		//DAO.close();       
	}
}
