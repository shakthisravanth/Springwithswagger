package com.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Customer;
 


@Repository
public class CustomerRepositoryImple implements CustomerRepository {
    private List<Customer> customers = new ArrayList<Customer>();
    private int nextId = 1;

    public List<Customer> findAll() {
        return customers;
    }

    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public Customer save(Customer customer) {
        if (customer.getId() == 0) {
            customer.setId(nextId++);
        }
        customers.add(customer);
        return customer;
    }

    public Customer update(int id, Customer customer) {
        for (Customer existing : customers) {
            if (existing.getId() == id) {
                existing.setName(customer.getName());
                existing.setEmail(customer.getEmail());
                existing.setPhone(customer.getPhone());
                return existing;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        Customer toRemove = null;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                toRemove = customer;
                break;
            }
        }
        if (toRemove != null) {
            customers.remove(toRemove);
            return true;
        }
        return false;
    }
}