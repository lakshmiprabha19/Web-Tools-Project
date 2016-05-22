package com.neu.myapplication.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myapplication.dao.CarDAO;
import com.neu.myapplication.dao.UserDAO;
import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.User;
import com.neu.myapplication.validator.CarValidator;
import com.neu.myapplication.validator.UserValidator;

@Controller
public class CarController {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	@Qualifier("carValidator")
	CarValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/addCar.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@RequestParam("photo") MultipartFile photoFile, @ModelAttribute("car") Car car, BindingResult result,MultipartHttpServletRequest request) throws Exception {
		validator.validate(car, result);
		String resultString = null;
		if (result.hasErrors()) {
			return "adminHomePage";
		}
		try {

			CarDAO carDao = new CarDAO();
			File file;
            String check = File.separator; 
            String path = null;
            if(check.equalsIgnoreCase("\\")) {
             path = context.getRealPath("").replace("build\\",""); 
         }
         
         if(check.equalsIgnoreCase("/")) {
            path = context.getRealPath("").replace("build/","");
            path += "/";

         }
        	if(car.getPhoto() != null){
                String fileNameWithExt = System.currentTimeMillis() + car.getPhoto().getOriginalFilename();
                file = new File(path+fileNameWithExt);
                String context1 = context.getContextPath();
                
                car.getPhoto().transferTo(file);
                
                car.setPhotoName(context1+ "/" + fileNameWithExt);
                carDao.addCar(car);
            }  
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "adminHomePage";		
	}
	
	@RequestMapping(value="/addCar.htm", method = RequestMethod.GET)
	public String initializeSignUpForm(@ModelAttribute("car") Car car, BindingResult result) {

		return "adminHomePage";
	}
	
	@RequestMapping(value="/getCars.htm", method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        ModelAndView mv = new ModelAndView("viewCars", "carList", carList);
        System.out.println("inside car list"+mv);
        return mv;
    }
}
