package com.udacity.jdnd.course3.critter.repository;


import com.udacity.jdnd.course3.critter.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(
            "SELECT c from Customer c " +
                    "INNER JOIN Pet e on c.id=e.customer.id " +
                    "WHERE e.id=:petId"


    )
    Optional<Customer> findByPetId(@Param("petId") Long petId);
}
