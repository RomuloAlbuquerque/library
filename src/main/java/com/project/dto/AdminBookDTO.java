package com.project.dto;

import java.io.Serializable;
import java.time.Instant;

import com.project.entities.AdminBook;
import com.project.entities.User;

public class AdminBookDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String author;
	private String title;
	private String description;
	private String publishingCompany;
	private Integer numberPages;
	private String category;
	private Instant publicationDate;
	private Instant registrationInstant;
	private String img;
	private User whoRegistered;
	
	public AdminBookDTO() {
		
	}
	
	public AdminBookDTO(Long id, String author, String title, String description, String publishingCompany,
			Integer numberPages, String category, Instant publicationDate, Instant registrationInstant, String img, User whoRegistered) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.description = description;
		this.publishingCompany = publishingCompany;
		this.numberPages = numberPages;
		this.category = category;
		this.publicationDate = publicationDate;
		this.registrationInstant = registrationInstant;
		this.img = img;
		this.whoRegistered = whoRegistered;
	}

	public AdminBookDTO(AdminBook entity) {
		this.id = entity.getId();
		this.author = entity.getAuthor();
		this.title = entity.getTitle();
		this.description = entity.getDescription();
		this.publishingCompany = entity.getPublishingCompany();
		this.numberPages = entity.getNumberPages();
		this.category = entity.getCategory();
		this.publicationDate = entity.getPublicationDate();
		this.registrationInstant = entity.getRegistrationInstant();
		this.img = entity.getImg();
		this.whoRegistered = entity.getWhoRegistered();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public Integer getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(Integer numberPages) {
		this.numberPages = numberPages;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Instant getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Instant publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Instant getRegistrationInstant() {
		return registrationInstant;
	}

	public void setRegistrationInstant(Instant registrationInstant) {
		this.registrationInstant = registrationInstant;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public User getWhoRegistered() {
		return whoRegistered;
	}

	public void setWhoRegistered(User whoRegistered) {
		this.whoRegistered = whoRegistered;
	}	
	
}
