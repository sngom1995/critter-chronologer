package com.udacity.jdnd.course3.critter.service;


import com.udacity.jdnd.course3.critter.domain.Customer;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
     public Customer getCustomerByPet(Long petId) {
        return customerRepository.findByPetId(petId).orElseThrow(EntityNotFoundException::new);
     }
}
