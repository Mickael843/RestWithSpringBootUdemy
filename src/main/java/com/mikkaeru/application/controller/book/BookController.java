package com.mikkaeru.application.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikkaeru.application.repository.BookRepository;

@RestController
@RequestMapping("/v1/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(bookRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(bookRepository.findById(id));
	}
}
