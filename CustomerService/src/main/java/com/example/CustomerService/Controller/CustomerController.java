package com.example.CustomerService.Controller;

import com.example.CustomerService.pojos.Customer;
import com.example.CustomerService.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService cs;
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String home() {
    	System.out.println("Hey");
    	return "CustomerPortal";
    }

    @GetMapping("/depositMoneyForm")
    public ModelAndView showDepositMoneyForm() {
        return new ModelAndView("depositMoneyForm");
    }

//    @PostMapping("/deposit")
//    public ModelAndView depositMoney(@RequestParam int acNo, @RequestParam double balance) {
//    	System.out.println("Ley");
//        Customer customer = cs.findCustomerByAccountNumber(acNo);
//        System.out.println(acNo+":"+balance);
//        if (customer != null) {
//            customer.setBalance(customer.getBalance() + balance);
//            cs.updateCustomer(customer);
//            return new ModelAndView("success", "message", "Money deposited! New balance: " + customer.getBalance());
//        } else {
//            return new ModelAndView("error", "errorMessage", "Customer not found.");
//        }
//    }

    @PostMapping("/depositt")
    public void depositMoney(@RequestBody Customer c) {
    	System.out.println("Leyndkfndkf");
    	int acNo=c.getAcno();
    	double balance=c.getBalance();
        Customer customer = cs.findCustomerByAccountNumber(acNo);
        System.out.println(acNo+":"+balance);
        if (customer != null) {
            customer.setBalance(customer.getBalance() + balance);
            cs.updateCustomer(customer);
            System.out.println("Yayyy");
//            return "dfd";
//            return customer;
//            return new ModelAndView("success", "message", "Money deposited! New balance: " + customer.getBalance());
        } else {
        	System.out.println("Oops");
//        	return "oops";
//        	return null;
//            return new ModelAndView("error", "errorMessage", "Customer not found.");
        }
    }

    @GetMapping("/withdrawMoneyForm")
    public ModelAndView showWithdrawMoneyForm() {
        return new ModelAndView("withdrawMoneyForm");
    }

//    @PostMapping("/withdraw")
//    public ModelAndView withdrawMoney(@RequestParam int acNo, @RequestParam double balance) {
//        Customer customer = cs.findCustomerByAccountNumber(acNo);
//        System.out.println("Outside");
//        if (customer != null && customer.getBalance() >= balance) {
//        	System.out.println("Inside");
//            customer.setBalance(customer.getBalance() - balance);
//            cs.updateCustomer(customer);
//            return new ModelAndView("success", "message", "Money withdrawn! New balance: " + customer.getBalance());
//        } else {
//            return new ModelAndView("error", "errorMessage", "Insufficient balance or customer not found.");
//        }
//    }
    @PostMapping("/withdraw")
    public String withdrawMoney(@RequestBody Customer c) {
    	int acNo=c.getAcno();
    	double balance=c.getBalance();
        Customer customer = cs.findCustomerByAccountNumber(acNo);
        System.out.println("Outside");
        if (customer != null && customer.getBalance() >= balance) {
        	System.out.println("Inside");
            customer.setBalance(customer.getBalance() - balance);
            cs.updateCustomer(customer);
            return "success";
//            return customer;
//            return new ModelAndView("success", "message", "Money withdrawn! New balance: " + customer.getBalance());
        } else {
        	return "Oops";
//            return new ModelAndView("error", "errorMessage", "Insufficient balance or customer not found.");
        }
    }
    @PostMapping("/checkBalance")
    public Customer checkBalance(@RequestBody Customer c) {
    	int acNo=c.getAcno();
        Customer customer = cs.findCustomerByAccountNumber(acNo);
        if (customer != null) {
        	return customer;
//            return new ModelAndView("success", "message", "Current balance: " + customer.getBalance());
        } else {
        	return null;
//            return new ModelAndView("error", "errorMessage", "Customer not found.");
        }
    }

    @GetMapping("/checkBalanceForm")
    public ModelAndView showCheckBalanceForm() {
        return new ModelAndView("checkBalanceForm");
    }

//    @PostMapping("/checkBalance")
//    public ModelAndView checkBalance(@RequestParam int acNo) {
//        Customer customer = cs.findCustomerByAccountNumber(acNo);
//        if (customer != null) {
//            return new ModelAndView("success", "message", "Current balance: " + customer.getBalance());
//        } else {
//            return new ModelAndView("error", "errorMessage", "Customer not found.");
//        }
//    }
}
