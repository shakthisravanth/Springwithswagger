package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Customer;
import com.repo.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer updateCustomer(int id, Customer customer) {
        return repository.update(id, customer);
    }

    public boolean deleteCustomer(int id) {
        return repository.delete(id);
    }
}