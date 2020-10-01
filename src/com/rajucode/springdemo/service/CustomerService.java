package com.rajucode.springdemo.service;

import java.util.List;

import com.rajucode.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer objCustomer);

	public Customer getCustomer(int custId);

	public void deleteCustomer(int custId);
}
