package com.puce.veterinaria.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name_pet", nullable = false, length = 100)
    private String name;
    @Column(name = "species", nullable = false, length = 100)
    private String species;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "owner_name", nullable = false, length = 100)
    private String ownerName;

}
