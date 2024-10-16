package com.example.AdminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AdminService.pojos.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
}
