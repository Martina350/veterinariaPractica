package com.puce.veterinaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puce.veterinaria.models.Pet;

@Repository 
public interface PetRepository extends JpaRepository<Pet, Integer> {
    Optional<Pet> findById(int id);
}
