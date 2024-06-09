package com.udacity.jdnd.course3.critter.service;


import com.udacity.jdnd.course3.critter.domain.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByAvailability(DayOfWeek daysAvailable) {
        return new ArrayList<>(employeeRepository.findAllByDaysAvailable(daysAvailable));
    }

    public void setAvailability(Set<DayOfWeek> daysAvailable, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(EntityNotFoundException::new);
        employee.setDaysAvailable(daysAvailable);
    }

    public List<Employee> getEmployeesForService(LocalDate localDate, Set<EmployeeSkill> skills) {
        Set<Employee> employees = employeeRepository.findAllByDaysAvailable(localDate.getDayOfWeek());
        Set<Employee> employeeSetWithSkills = new HashSet<>();
        for (Employee employee : employees) {
            if (employee.getSkills().containsAll(skills)) {
                employeeSetWithSkills.add(employee);
            }
        }
        return new ArrayList<>(employeeSetWithSkills);
    }
}
