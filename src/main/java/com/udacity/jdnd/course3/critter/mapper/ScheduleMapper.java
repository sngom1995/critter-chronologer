package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.domain.Employee;
import com.udacity.jdnd.course3.critter.domain.Pet;
import com.udacity.jdnd.course3.critter.domain.Schedule;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.*;

@RequiredArgsConstructor
@Component
public class ScheduleMapper {
    private final PetService petService;
    private final EmployeeService employeeService;

    public Schedule map(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        List<Long> petIds = scheduleDTO.getPetIds();
        List<Long> employeeIds = scheduleDTO.getEmployeeIds();
        Set<Pet> pets = new HashSet<>();
        Set<Employee> employees = new HashSet<>();
        employeeIds.forEach(
               employeeId -> employees.add(employeeService.getEmployeeById(employeeId))
        );
        petIds.forEach( petId -> pets.add(petService.getPetById(petId)));
        schedule.setEmployees(employees);
        schedule.setPets(pets);
        schedule.setDate(scheduleDTO.getDate());
        schedule.setActivities(scheduleDTO.getActivities());
        return schedule;
    }
    public  ScheduleDTO map(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        List<Long> petIds = new ArrayList<>();
        if (schedule.getPets() != null ) {
            schedule.getPets().forEach( pet -> petIds.add(pet.getId()));
        }
        List<Long> employeeIds = new ArrayList<>();
        if (schedule.getEmployees() != null ) {
            schedule.getEmployees().forEach(employee ->employeeIds.add(employee.getId()));
        }
        scheduleDTO.setPetIds(petIds);
        scheduleDTO.setEmployeeIds(employeeIds);
        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setDate(schedule.getDate());
        scheduleDTO.setActivities(schedule.getActivities());
        return scheduleDTO;
    }
}
