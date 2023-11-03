package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ResourceNotFoundException;

@RestController
public class MathControllerExponencial {
	@GetMapping("/exp/{numberOne}/{numberTwo}")
	public Double exp(
			@PathVariable String numberOne,
			@PathVariable String numberTwo
			) throws Exception {
		if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new ResourceNotFoundException("Please set a numeric value");
			}
		Double expResult = Math.pow(Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
		
		return (expResult);
	}
}
