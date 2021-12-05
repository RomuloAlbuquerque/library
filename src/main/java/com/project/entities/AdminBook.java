package com.project.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "tb_admin_book")
public class AdminBook implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String author;
	private String title;
	private String description;
	private String publishingCompany;
	private Integer numberPages;
	private String category;
	private Instant publicationDate;
	private String img;
	
	@OneToOne
	private User whoRegistered;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant registrationInstant;
	
	public AdminBook() {
		
	}
	
	public AdminBook(Long id, String author, String title, String description, String publishingCompany, Integer numberPages,
			String category, Instant publicationDate, String img, User whoRegistered, Instant registrationInstant) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.description = description;
		this.publishingCompany = publishingCompany;
		this.numberPages = numberPages;
		this.category = category;
		this.publicationDate = publicationDate;
		this.img = img;
		this.whoRegistered = whoRegistered;
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

	public Instant getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Instant publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Instant getRegistrationInstant() {
		return registrationInstant;
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

	@PrePersist
	public void prePersist() {
		registrationInstant = Instant.now();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminBook other = (AdminBook) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
