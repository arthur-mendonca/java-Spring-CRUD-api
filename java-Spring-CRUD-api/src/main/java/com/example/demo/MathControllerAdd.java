package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UnsupportedMathOperationExcepetion;

@RestController
public class MathControllerAdd {
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExcepetion("Please set a numeric value");
			}
		return MathUtils.convertToDouble(numberOne) + MathUtils.convertToDouble(numberTwo);
	}
}
