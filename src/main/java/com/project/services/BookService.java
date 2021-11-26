package com.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.BookDTO;
import com.project.entities.Book;
import com.project.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	@Transactional
	public BookDTO findById(Long id) {
		Optional<Book> obj = repository.findById(id);
		Book entity = obj.get();
		return new BookDTO(entity);
	}

}
