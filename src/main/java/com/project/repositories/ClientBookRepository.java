package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.ClientBook;

@Repository
public interface ClientBookRepository extends JpaRepository<ClientBook, Long> {

}
