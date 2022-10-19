package com.heakl.banksystem.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.getAllCustomersWithDate();
    }

    public Optional<Customer> findCustomerByName(String name){
        return customerRepository.findByName(name);
    }
}
