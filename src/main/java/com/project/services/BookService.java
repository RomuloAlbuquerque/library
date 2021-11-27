package com.project.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new BookDTO(entity);
	}
	
	@Transactional
	public BookDTO update(Long id, BookDTO dto) {
		try {
			Book entity = repository.getOne(id);
			entity.setTitle(dto.getTitle());
			entity = repository.save(entity);
			return new BookDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	private void copyDtoToEntity(BookDTO dto, Book entity) {
		entity.setAuthor(dto.getAuthor());
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setPublishingCompany(dto.getPublishingCompany());
		entity.setNumberPages(dto.getNumberPages());
		entity.setCategory(dto.getCategory());
		entity.setPublicationDate(dto.getPublicationDate());
	}	

}
