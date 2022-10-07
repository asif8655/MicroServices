package com.techgatha.repository;

import org.springframework.data.repository.CrudRepository;

import com.techgatha.model.Book;

public interface BookRepository extends CrudRepository<Book, String>{

}
