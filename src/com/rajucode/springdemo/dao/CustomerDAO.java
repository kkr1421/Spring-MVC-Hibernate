package com.rajucode.springdemo.dao;

import java.util.List;

import com.rajucode.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer objCustomer);

	public Customer getCustomer(int custId);

	public void deleteCustomer(int custId);
}
