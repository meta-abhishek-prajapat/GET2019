package com.metacube.springJDBC.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface CustomValidator {

	public void passwordMisMatch(Object target, BindingResult errors);
	
}
