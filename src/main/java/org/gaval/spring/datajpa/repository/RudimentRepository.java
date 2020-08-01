package org.gaval.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.gaval.spring.datajpa.model.Rudiment;

public interface RudimentRepository extends JpaRepository<Rudiment, Long> {
	List<Rudiment> findByPublished(boolean published);
	List<Rudiment> findByNameContaining(String name);
}

