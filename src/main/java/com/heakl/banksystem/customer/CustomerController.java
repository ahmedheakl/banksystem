package com.heakl.banksystem.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @GetMapping(path = "customers")
    @CrossOrigin(origins = "*")
    public List<Customer> GetCustomers(){
        return customerService.findAllCustomers();
    }

    @PostMapping(path = "customers")
    public void PostCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @RequestMapping(value = "customer/{name}", method = RequestMethod.GET)
    public Optional<Customer> GetCustomerByName(@PathVariable(value = "name") String name){
        return customerService.findCustomerByName(name);
    }
}
