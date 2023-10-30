package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ResourceNotFoundException;

@RestController
public class MathControllerExponencial {
	@RequestMapping(value="/exp/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double exp(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new ResourceNotFoundException("Please set a numeric value");
			}
		Double expResult = Math.pow(Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
		
		return (expResult);
	}
}
