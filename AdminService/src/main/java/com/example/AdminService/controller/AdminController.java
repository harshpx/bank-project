package com.example.AdminService.controller;


import com.example.AdminService.pojos.Customer;
import com.example.AdminService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@Controller
@RestController
public class AdminController {

    @Autowired
    private CustomerService customerService;
    
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String home() {
    	System.out.println("Hey");
    	return "adminPortal";
    }
    @GetMapping("/addCustomerForm")
    public ModelAndView showAddCustomerForm() {
        return new ModelAndView("addCustomer");
    }

//    @PostMapping("/addCustomer")
//    public ModelAndView addCustomer(@RequestParam int acNo, @RequestParam String name, @RequestParam double balance) {
//    	System.out.println("From postform");
//        Customer customer = new Customer();
//        customer.setAcno(acNo);
//        customer.setName(name);
//        customer.setBalance(balance);
//        customerService.addCustomer(customer);
//        return new ModelAndView("success", "message", "Customer added successfully!");
//    }
    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer c) {
    	System.out.println("From postformadminservice");
//        Customer customer = new Customer();
//        customer.setAcno(acNo);
//        customer.setName(name);
//        customer.setBalance(balance);
        customerService.addCustomer(c);
//        return new ModelAndView("success", "message", "Customer added successfully!");
    }

//    @GetMapping("/listCustomers")
//    public ModelAndView listCustomers() {
//        List<Customer> customers = customerService.findAllCustomers();
//        return new ModelAndView("listCustomer", "customers", customers);
//    }
    @GetMapping("/listCustomers")
    public List<Customer> listCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        return customers;
//        return new ModelAndView("listCustomer", "customers", customers);
    }

    @GetMapping("/searchCustomerForm")
    public ModelAndView showSearchCustomerForm() {
        return new ModelAndView("searchCustomerbyId");
    }

//    @GetMapping("/searchCustomer")
//    public ModelAndView searchCustomer(@RequestParam int acNo) {
//        Customer customer = customerService.findCustomerByAccountNumber(acNo);
//        if (customer != null) {
//            return new ModelAndView("searchCustomerResult", "customer", customer);
//        } else {
//            return new ModelAndView("error", "errorMessage", "Customer not found.");
//        }
//    }
    @GetMapping("/searchCustomer")
    public Customer searchCustomer(@RequestParam int acNo) {
        Customer customer = customerService.findCustomerByAccountNumber(acNo);
        if (customer != null) {
        	return customer;
//            return new ModelAndView("searchCustomerResult", "customer", customer);
        } else {
        	return null;
//            return new ModelAndView("error", "errorMessage", "Customer not found.");
        }
    }
}