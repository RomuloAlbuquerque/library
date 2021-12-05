package com.project.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.AdminBookDTO;
import com.project.entities.AdminBook;
import com.project.repositories.AdminBookRepository;
import com.project.services.exceptions.ResourceNotFoundException;

@Service
public class AdminBookService {
	
	@Autowired
	private AdminBookRepository repository;
	
	@Transactional
	public AdminBookDTO findById(Long id) {
		Optional<AdminBook> obj = repository.findById(id);
		AdminBook entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AdminBookDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<AdminBookDTO> findAllPaged(Pageable pageable) {
		Page<AdminBook> list = repository.findAll(pageable);
		return list.map(x -> new AdminBookDTO(x));
	}
	
	@Transactional
	public AdminBookDTO insert(AdminBookDTO dto) {
		AdminBook entity = new AdminBook();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AdminBookDTO(entity);
	}
	
	@Transactional
	public AdminBookDTO update(Long id, AdminBookDTO dto) {
		try {
			AdminBook entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new AdminBookDTO(entity);
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
	
	/*
	public void deleteForClient(Long id) {
		User user = userRepository.findByEmail(authentication.getName());
		Set<Role> rolesSet = new HashSet<>();
		rolesSet = user.getRoles();
		for(Role role : rolesSet){
            if(role.getId() == 2) {
            	Optional<Book> obj = repository.findById(id);
            	Book entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
            	entity.get
            }
        }
		
	}
	*/
	
	private void copyDtoToEntity(AdminBookDTO dto, AdminBook entity) {
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
