package com.example.FrontendService.pojos;

public class Customer {
	private int acNo;
	private String name;
	private Double balance;
	public int getAcno() {
		return acNo;
	}
	@Override
	public String toString() {
		return "Customer [acNo=" + acNo + ", name=" + name + ", balance=" + balance + "]";
	}
	public void setAcno(int acNo) {
		this.acNo = acNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}

