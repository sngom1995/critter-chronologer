package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.domain.Pet;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Transactional
public class PetService {
    private final PetRepository petRepository;

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElseThrow(EntityExistsException::new);
    }

    public List<Pet> getPetsByOwner(Long ownerId) {
        return new ArrayList<>(petRepository.findPetsByOwnerId(ownerId));
    }
    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    public void updatePet(PetDTO updatePetDTO, Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(EntityExistsException::new);
        pet.setName(updatePetDTO.getName());
        pet.setNotes(updatePetDTO.getNotes());
        petRepository.save(pet);
    }
}
