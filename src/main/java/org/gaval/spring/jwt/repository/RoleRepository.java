package org.gaval.spring.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.gaval.spring.jwt.models.ERole;
import org.gaval.spring.jwt.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional <Role> findByName(ERole name);
}

