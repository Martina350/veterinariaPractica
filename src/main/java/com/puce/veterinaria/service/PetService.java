package com.puce.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.puce.veterinaria.models.Pet;
import com.puce.veterinaria.repository.PetRepository;

@Service
public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(int id) {
        return petRepository.findById(id);
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public Optional<Pet> updatePet(int id, Pet petUpdated) {
        return petRepository.findById(id).map(pet -> {
            pet.setName(petUpdated.getName());
            pet.setSpecies(petUpdated.getSpecies());
            pet.setAge(petUpdated.getAge());
            pet.setOwnerName(petUpdated.getOwnerName());
            return petRepository.save(pet);
        });
    }

    public boolean deletPet(int id) {
       if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
