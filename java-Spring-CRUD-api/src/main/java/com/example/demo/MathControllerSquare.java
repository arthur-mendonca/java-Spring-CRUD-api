package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UnsupportedMathOperationExcepetion;

@RestController
public class MathControllerSquare {
	@RequestMapping(value="/sqr/{numberOne}/", 
			method=RequestMethod.GET)
	public Double sqr(
			@PathVariable(value = "numberOne") String numberOne
			) throws Exception {
		if(!MathUtils.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationExcepetion("Please set a numeric value");
			}
		
		return Math.sqrt(MathUtils.convertToDouble(numberOne));
	}
}
