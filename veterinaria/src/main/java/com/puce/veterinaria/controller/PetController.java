package com.puce.veterinaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puce.veterinaria.models.Pet;
import com.puce.veterinaria.service.PetService;



@RestController
@RequestMapping("/api/pet")
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    
    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable int id) {
        return petService.getPetById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
    }

    @PostMapping("/create")
    public ResponseEntity<Pet> savePet(@RequestBody Pet pet) {
        Pet newPet = petService.savePet(pet);
        return new ResponseEntity<>(newPet, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable int id, @RequestBody Pet petUpdated) {
        return petService.updatePet(id, petUpdated)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable int id) {
        if (petService.deletPet(id)) {
            return ResponseEntity.noContent().build();
        } else {
            throw new RuntimeException("Pet not found with id: " + id);
        }
    }
}
