package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.TechLead;

@Repository
public interface TechLeadRepository extends JpaRepository<TechLead, Long> {

}
