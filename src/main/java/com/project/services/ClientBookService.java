package com.project.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.ClientBookDTO;
import com.project.entities.ClientBook;
import com.project.repositories.ClientBookRepository;
import com.project.services.exceptions.ResourceNotFoundException;

@Service
public class ClientBookService {
	
	@Autowired
	private ClientBookRepository repository;
	
	@Transactional
	public ClientBookDTO findById(Long id) {
		Optional<ClientBook> obj = repository.findById(id);
		ClientBook entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientBookDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<ClientBookDTO> findAllPaged(PageRequest pageRequest) {
		Page<ClientBook> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientBookDTO(x));
	}
	
	@Transactional
	public ClientBookDTO insert(ClientBookDTO dto) {
		ClientBook entity = new ClientBook();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ClientBookDTO(entity);
	}
	
	@Transactional
	public ClientBookDTO update(Long id, ClientBookDTO dto) {
		try {
			ClientBook entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ClientBookDTO(entity);
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
	
	private void copyDtoToEntity(ClientBookDTO dto, ClientBook entity) {
		entity.setAuthor(dto.getAuthor());
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setPublishingCompany(dto.getPublishingCompany());
		entity.setNumberPages(dto.getNumberPages());
		entity.setCategory(dto.getCategory());
		entity.setPublicationDate(dto.getPublicationDate());
		entity.setImg(dto.getImg());
	}	

}
