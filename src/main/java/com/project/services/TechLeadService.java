package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.TechLeadDTO;
import com.project.entities.TechLead;
import com.project.repositories.TechLeadRepository;

@Service
public class TechLeadService {
	
	@Autowired
	private TechLeadRepository repository;
	
	@Transactional
	public TechLeadDTO insert(TechLeadDTO dto) {
		TechLead entity = new TechLead();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new TechLeadDTO(entity);
	}
	
	private void copyDtoToEntity(TechLeadDTO dto, TechLead entity) {
		entity.setName(dto.getName());
	}	

}
