package com.udacity.jdnd.course3.critter.domain;


import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import lombok.Data;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ElementCollection
    @JoinTable(name = "employee_skills")
    private Set<EmployeeSkill> skills = new HashSet<>();

    @ElementCollection
    @JoinTable(name = "employee_day_of_w_available")
    private Set<DayOfWeek> daysAvailable = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "schedule_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    private Set<Schedule> schedules = new HashSet<>();

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }
}
