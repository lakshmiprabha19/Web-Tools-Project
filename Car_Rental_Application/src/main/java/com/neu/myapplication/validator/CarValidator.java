package com.neu.myapplication.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.User;

public class CarValidator implements Validator{

	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(Car.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Car car = (Car) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carName", "error.invalid.car", "Car Name,");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carBrand", "error.invalid.car", "Car Brand, ");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carModel", "error.invalid.car", "Car Model,");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "error.invalid.car", "Color Required");
	}

}
