package com.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entities.AdminBook;
import com.project.entities.ClientBook;
import com.project.repositories.AdminBookRepository;
import com.project.repositories.ClientBookRepository;

@Service
public class AllBooksService {
	
	@Autowired
	private AdminBookRepository adminBookRepository;
	
	@Autowired
	private ClientBookRepository clientBookRepository;
	
	@Transactional(readOnly = true)
	public List<Object> findAllBooks() {
		List<AdminBook> list = adminBookRepository.findAll();
		List<ClientBook> listClientBook = clientBookRepository.findAll(); 
		
		List<Object> listObject = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
		    listObject.add(list.get(i));
		}for(int i = 0; i < listClientBook.size(); i++){
		    listObject.add(listClientBook.get(i));
		}
		return listObject;
	}

}
