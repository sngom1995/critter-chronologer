package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {


    @Query(
            "select p from Pet p  where p.customer.id=:ownerId"
    )
    Set<Pet> findPetsByOwnerId(@Param("ownerId") Long ownerId);
}
