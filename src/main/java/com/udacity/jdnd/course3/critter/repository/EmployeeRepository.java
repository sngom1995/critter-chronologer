package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Set;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(
            "SELECT e FROM Employee e " +
                    "WHERE :day MEMBER OF e.daysAvailable"
    )
    Set<Employee> findAllByDaysAvailable(@Param("day") DayOfWeek day);
}
