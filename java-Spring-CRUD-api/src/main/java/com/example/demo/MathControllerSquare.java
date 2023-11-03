package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ResourceNotFoundException;

@RestController
public class MathControllerSquare {
	@GetMapping("/sqr/{numberOne}/")
	public Double sqr(
			@PathVariable String numberOne
			) throws Exception {
		if(!MathUtils.isNumeric(numberOne)) {
			throw new ResourceNotFoundException("Please set a numeric value");
			}
		
		return Math.sqrt(MathUtils.convertToDouble(numberOne));
	}
}
