package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.domain.Customer;
import com.udacity.jdnd.course3.critter.domain.Pet;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PetMapper {
    private final PetService petService;
    private final CustomerService customerService;
    public Pet toEntity(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setId(petDTO.getId());
        pet.setName(petDTO.getName());
        pet.setType(petDTO.getType());
        pet.setNotes(petDTO.getNotes());
        Customer customer = customerService.getCustomerById(petDTO.getOwnerId());
        System.out.println("customer "+customer);
        pet.setCustomer(customer);
        return pet;
    }
    public  PetDTO toPetDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setName(pet.getName());
        petDTO.setType(pet.getType());
        petDTO.setNotes(pet.getNotes());
        petDTO.setOwnerId(pet.getCustomer().getId());
        return petDTO;
    }
}
