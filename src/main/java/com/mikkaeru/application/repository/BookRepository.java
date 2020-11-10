package com.mikkaeru.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikkaeru.application.domain.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
