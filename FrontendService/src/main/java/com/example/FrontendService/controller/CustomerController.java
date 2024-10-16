package com.example.FrontendService.controller;

//import com.bank.frontend.model.Login;
import com.example.FrontendService.pojos.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String CUSTOMER_SERVICE_URL = "http://localhost:8083/CustomerService/";



    // Show deposit money form
    @GetMapping("/depositFormCustomer")
    public String showDepositForm() {
        return "depositForm";
    }

    // Process deposit money
    @GetMapping("/depositCustomer")
    public String processDeposit(@RequestParam int acNo, @RequestParam double balance, Model model) {
    	System.out.println("From deposit method");
        String url = CUSTOMER_SERVICE_URL + "depositt";
        Customer customer = new Customer();
        customer.setAcno(acNo);
        customer.setName(null);
        customer.setBalance(balance);
        try {
        	Customer updatedCustomer = restTemplate.postForObject(url, customer, Customer.class);
        }catch(Exception e) {
        	System.out.println("oops!");
        }
        
        model.addAttribute("message", "Money deposited!");
        return "success";
    }

    // Show withdraw money form
    @GetMapping("/withdrawFormCustomer")
    public String showWithdrawForm() {
        return "withdrawForm";
    }

    // Process withdraw money
    @GetMapping("/withdrawCustomer")
    public String processWithdraw(@RequestParam int acNo, @RequestParam double balance, Model model) {
    	System.out.println("From withdraw method");
        String url = CUSTOMER_SERVICE_URL + "withdraw";
        Customer customer = new Customer();
        customer.setAcno(acNo);
        customer.setName(null);
        customer.setBalance(balance);
        String message=restTemplate.postForObject(url, customer, String.class);
        System.out.println(message);
        model.addAttribute("message", "Money withdrawn! ");
        return "success";
    }
    @GetMapping("/checkBalanceFormCustomer")
    public ModelAndView showCheckBalanceForm() {
        return new ModelAndView("checkBalanceForm");
    }
    @GetMapping("/checkBalance")
    public String checkBalance(@RequestParam int acNo, Model model) {
    	System.out.println("From checkbalance method");
        String url = CUSTOMER_SERVICE_URL + "checkBalance";
        Customer customer = new Customer();
        customer.setAcno(acNo);
        customer.setName(null);
        customer.setBalance(0.0);
        Customer message=restTemplate.postForObject(url, customer, Customer.class);
        System.out.println(message);
        model.addAttribute("customer", message);
        return "searchResult";
    }
}