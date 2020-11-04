package com.mikkaeru.application.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(BAD_REQUEST)
public class UsuportedMathOperationExeption extends RuntimeException {

	private static final long serialVersionUID = 305119602991823943L;

	public UsuportedMathOperationExeption(String exception) {
		super(exception);
	}
}
