package com.udacity.jdnd.course3.critter.domain;


import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "schedule_employee",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> employees = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "schedule_pet",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Set<Pet> pets = new HashSet<>();

    @ElementCollection
    @JoinTable(name = "schedule_skills")
    private Set<EmployeeSkill> activities =  new HashSet<>();

    public void addEmployee(Employee employee) {
        this.getEmployees().add(employee);
    }
    public void addPet(Pet pet) {
        this.getPets().add(pet);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
