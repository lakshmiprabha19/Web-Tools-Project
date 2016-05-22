package com.neu.myapplication.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.myapplication.pojo.User;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		
	}

}
