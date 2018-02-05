package com.petshop.petshop.security.repository;


import com.petshop.petshop.model.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for working with the database.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
