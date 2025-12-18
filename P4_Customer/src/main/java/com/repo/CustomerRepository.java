package com.repo;

import java.util.List;

import com.model.Customer;


public interface CustomerRepository {

    public List<Customer> findAll();

    public Customer findById(int id);

    public Customer save(Customer customer);

    public Customer update(int id, Customer customer);

    public boolean delete(int id);

}