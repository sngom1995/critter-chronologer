package com.udacity.jdnd.course3.critter.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udacity.jdnd.course3.critter.pet.PetType;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nationalized
    private String name;

    @Enumerated(EnumType.STRING)
    private PetType type;

    private LocalDate birthDate;

    private String notes;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @ManyToMany
    @JoinTable(

            name = "schedule_pet",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    private Set<Schedule> schedules = new HashSet<>();

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

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }
    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }
}
