package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.domain.Employee;
import com.udacity.jdnd.course3.critter.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findScheduleByEmployees(Employee employee);

    @Query(
            "SELECT s FROM Schedule s " +
                    "INNER JOIN s.pets sp " +
                    "WHERE sp.id=:petId"
    )
    Set<Schedule> findAllByPetId(@Param("petId") Long petId);

    @Query("SELECT s from Schedule s " +
            "inner join s.employees se " +
            "WHERE se.id=:employeeId")
    Set<Schedule> findAllByEmployees(@Param("employeeId") Long employeeId);


    @Query(
            "SELECT s FROM Schedule s " +
                    "INNER JOIN s.pets sp " +
                    "INNER JOIN sp.customer c " +
                    "WHERE c.id =:customerId"
    )
    Set<Schedule> findAllByCustomerId(@Param("customerId") Long customerId);
}
