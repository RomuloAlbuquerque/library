package com.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.BookDTO;
import com.project.entities.Book;
import com.project.repositories.BookRepository;
import com.project.services.exceptions.ResourceNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	@Transactional
	public BookDTO findById(Long id) {
		Optional<Book> obj = repository.findById(id);
		Book entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new BookDTO(entity);
	}
	
	@Transactional
	public BookDTO insert(BookDTO dto) {
		Book entity = new Book();
		entity.setAuthor(dto.getAuthor());
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setPublishingCompany(dto.getPublishingCompany());
		entity.setNumberPages(dto.getNumberPages());
		entity.setCategory(dto.getCategory());
		entity.setPublicationDate(dto.getPublicationDate());
		entity = repository.save(entity);
		return new BookDTO(entity);
	}

}
