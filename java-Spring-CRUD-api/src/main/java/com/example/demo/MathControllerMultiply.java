package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ResourceNotFoundException;

@RestController
public class MathControllerMultiply {
	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(
			@PathVariable String numberOne,
			@PathVariable String numberTwo
			) throws Exception {
		if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new ResourceNotFoundException("Please set a numeric value");
			}
		return MathUtils.convertToDouble(numberOne) * MathUtils.convertToDouble(numberTwo);
	}
}
