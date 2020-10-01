package com.rajucode.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rajucode.springdemo.entity.Customer;
import com.rajucode.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomController {

	//need to inject customerDAO
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel){
		//get the customers
		List<Customer> lstCustomers = customerService.getCustomers();
		theModel.addAttribute("customers",lstCustomers);
		return "list-customers";
		
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Customer objCust= new Customer();
		theModel.addAttribute("customer", objCust);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer objCustomer){
		customerService.saveCustomer(objCustomer);
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int custId,Model theModel){
		Customer objCustomer = customerService.getCustomer(custId);
		theModel.addAttribute("customer",objCustomer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int custId){
		customerService.deleteCustomer(custId);
		return "redirect:/customer/list";
	}
	
}
