package com.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.services.AllBooksService;

@RestController
@RequestMapping(value = "/allbooks")
public class AllBooksResource {
	
	@Autowired
	private AllBooksService service;
	
	@GetMapping
	public ResponseEntity<List<Object>> findAllBooks(
			) {
		
		List<Object> list = service.findAllBooks();
		
		return ResponseEntity.ok().body(list);
	}

}
