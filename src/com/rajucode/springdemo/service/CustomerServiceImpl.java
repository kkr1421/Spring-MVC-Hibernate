package com.rajucode.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajucode.springdemo.dao.CustomerDAO;
import com.rajucode.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer objCustomer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(objCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int custId) {
		return customerDAO.getCustomer(custId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int custId) {
		customerDAO.deleteCustomer(custId);
	}

}
