package com.example.FrontendService.controller;

import com.example.FrontendService.pojos.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String ADMIN_SERVICE_URL = "http://localhost:8083/AdminService/";

    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String fun() {
    	return "chooseRole";
    }
    
    @GetMapping("/addCustomerFormAdmin")
    public String showAddCustomerForm() {
        return "addCustomerForm";
    }
    @GetMapping("/AdminPortalAdmin")
    public ModelAndView showDepositMoneyForm() {
    	System.out.println("adminportal");
        return new ModelAndView("adminPortal");
    }
    @RequestMapping("/customerPortalCustomer")
    public String customerPortal() {
    	System.out.println("custoemrportal");
        return "customerPortal";
    }
    @GetMapping("/addCustomerAdmin")
    public String addCustomer(@RequestParam int acNo, @RequestParam String name, @RequestParam double balance) {
    	System.out.println("Inside add customer");
        String url = ADMIN_SERVICE_URL + "addCustomer";
        Customer customer = new Customer();
        customer.setAcno(acNo);
        customer.setName(name);
        customer.setBalance(balance);
        restTemplate.postForObject(url, customer, Customer.class);

      return "success";
    }
    
    @GetMapping("/searchCustomerFormAdmin")
    public String showSearchCustomerForm() {
        return "searchCustomer";
    }

    // Search customer by account number
    @GetMapping("/searchCustomer")
    public String searchCustomer(@RequestParam("acNo") int acNo, Model model) {
        String url = ADMIN_SERVICE_URL + "/searchCustomer?acNo=" + acNo;
        Customer customer = restTemplate.getForObject(url, Customer.class);

        if (customer != null) {
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("errorMessage", "Customer not found with Account Number: " + acNo);
        }

        return "searchResult";  
    }
    

 
    @GetMapping("/listCustomersAdmin")
    public String listCustomers(Model model)   {      
        String url = ADMIN_SERVICE_URL + "listCustomers";
        Customer[] customersArray = restTemplate.getForObject(url, Customer[].class);
        System.out.println(customersArray.length);
        List<Customer> customers = Arrays.asList(customersArray);
        for(Customer c:customers) {
        	System.out.println(c);
        }

        
        model.addAttribute("customers", customers);
        return "listCustomers";
    }

}