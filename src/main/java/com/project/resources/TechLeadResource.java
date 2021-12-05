package com.project.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.dto.TechLeadDTO;
import com.project.services.TechLeadService;

@RestController
@RequestMapping(value = "/techlead")
public class TechLeadResource {
	
	@Autowired
	private TechLeadService service;
	
	@PostMapping
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<TechLeadDTO> insert(@RequestBody TechLeadDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}
