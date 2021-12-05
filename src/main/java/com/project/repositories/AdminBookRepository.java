package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.AdminBook;

@Repository
public interface AdminBookRepository extends JpaRepository<AdminBook, Long> {

}
