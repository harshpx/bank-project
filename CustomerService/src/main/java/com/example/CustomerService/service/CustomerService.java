package com.example.CustomerService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CustomerService.pojos.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addCustomer(Customer c) {
		em.persist(c);
	}
	public Customer findCustomerByAccountNumber(int acno) {
		return em.find(Customer.class, acno);
	}
	public List<Customer> findAllCustomers(){
		return em.createQuery("SELECT c FROM Customer c",Customer.class).getResultList();
		
	}
	@Transactional
	public void updateCustomer(Customer c) {
		em.merge(c);
	}
	
	
}
