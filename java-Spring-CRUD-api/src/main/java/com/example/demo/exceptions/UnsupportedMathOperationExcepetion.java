package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationExcepetion extends RuntimeException {

	public UnsupportedMathOperationExcepetion(String ex) {
		super(ex);
		
	}

	private static final long serialVersionUID = 1L;
}
