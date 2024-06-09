package com.udacity.jdnd.course3.critter.domain;


import lombok.Data;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

import java.util.LinkedList;
import java.util.List;



@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nationalized
    private String name;
    private String phoneNumber;
    private String notes;

    @OneToMany(mappedBy = "customer")
    private List<Pet> pets = new LinkedList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
