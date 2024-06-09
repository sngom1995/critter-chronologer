package com.udacity.jdnd.course3.critter.service;


import com.udacity.jdnd.course3.critter.domain.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Schedule updateSchedule(Schedule schedule, Long id) {
        Schedule scheduleToUpdate = getScheduleById(id);
        scheduleToUpdate.setEmployees(schedule.getEmployees());
        scheduleToUpdate.setPets(schedule.getPets());
        return scheduleRepository.save(scheduleToUpdate);
    }
    public void deleteSchedule(Schedule schedule) {
        scheduleRepository.delete(schedule);
    }
    public List<Schedule> getScheduleForPet(Long petId) {
        return new ArrayList<>(scheduleRepository.findAllByPetId(petId));
    }

    public List<Schedule> getScheduleForEmployee(Long employeeId) {
        return new ArrayList<>(scheduleRepository.findAllByEmployees(employeeId));
    }

    public List<Schedule> getScheduleForCustomer(Long customerId) {
        return new ArrayList<>(scheduleRepository.findAllByCustomerId(customerId));
    }
}
