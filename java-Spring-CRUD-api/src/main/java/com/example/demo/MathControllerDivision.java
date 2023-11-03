package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ResourceNotFoundException;


@RestController
public class MathControllerDivision {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double div(
			@PathVariable String numberOne,
			@PathVariable String numberTwo
			) throws Exception {
		if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new ResourceNotFoundException("Please set a numeric value");
			}
		return MathUtils.convertToDouble(numberOne) / MathUtils.convertToDouble(numberTwo);
	}

	
}

