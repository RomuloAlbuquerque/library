package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;

}
