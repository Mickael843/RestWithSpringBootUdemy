package com.mikkaeru.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikkaeru.application.domain.model.NumberOperation;

@RestController
@RequestMapping("/math")
public class MathController {

	@GetMapping("/sum")
	public Double sum(@RequestBody NumberOperation numberOperation) throws Exception {
		return numberOperation.sum();
	}
	
	@GetMapping("/subtraction")
	public Double subtraction(@RequestBody NumberOperation numberOperation) throws Exception {
		return numberOperation.subtraction();
	}
	
	@GetMapping("/multiplication")
	public Double multiplication(@RequestBody NumberOperation numberOperation) throws Exception {
		return numberOperation.multiplication();
	}
	
	@GetMapping("/division")
	public Double division(@RequestBody NumberOperation numberOperation) throws Exception {
		return numberOperation.division();
	}
	
	@GetMapping("/mean")
	public Double mean(@RequestBody NumberOperation numberOperation) throws Exception {
		return numberOperation.mean();
	}
	
	@GetMapping("/square-root/{numberOne}")
	public Double squareRoot(@RequestBody NumberOperation numberOperation) throws Exception {
		return numberOperation.squareRoot();
	}
}
