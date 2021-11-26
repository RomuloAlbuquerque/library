package com.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.BookDTO;
import com.project.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookResource {
	
	@Autowired
	private BookService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BookDTO> findById(@PathVariable Long id){
		BookDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

}
