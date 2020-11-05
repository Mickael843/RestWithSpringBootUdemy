package com.mikkaeru.application.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 305119602991823943L;

	public ResourceNotFoundExeption(String exception) {
		super(exception);
	}
}
