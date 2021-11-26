package com.project.dto;

import java.time.Instant;
import java.util.Date;

public class BookDTO {
	
	private Long id;
	private String author;
	private String title;
	private String description;
	private String publishingCompany;
	private Integer numberPages;
	private String category;
	private Date publicationDate;
	private Instant registrationInstant;
	
	public BookDTO() {
		
	}

	public BookDTO(Long id, String author, String title, String description, String publishingCompany,
			Integer numberPages, String category, Date publicationDate, Instant registrationInstant) {
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

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Instant getRegistrationInstant() {
		return registrationInstant;
	}

	public void setRegistrationInstant(Instant registrationInstant) {
		this.registrationInstant = registrationInstant;
	}
	
	

}
