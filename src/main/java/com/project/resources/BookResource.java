package com.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.project.services.BookService;

@RestController
public class BookResource {
	
	@Autowired
	private BookService service;

}
