package com.petshop.petshop.repository;

import com.petshop.petshop.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository <Pet, Integer>{
}
