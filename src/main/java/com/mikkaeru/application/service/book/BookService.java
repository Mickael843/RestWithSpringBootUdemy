package com.mikkaeru.application.service.book;

import com.mikkaeru.application.domain.model.Book;

public interface BookService {

	Book create(Book book);
	Book update(Book book);
	void delete(Long id);
}
