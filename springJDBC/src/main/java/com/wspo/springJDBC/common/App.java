package com.wspo.springJDBC.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wspo.springJDBC.customer.dao.CustomerDAO;
import com.wspo.springJDBC.customer.model.Customer;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringModule.xml");

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		// Customer customer = new Customer(3, "wspo",39);
		// customerDAO.insert(customer);
		 Customer customer1 = customerDAO.findByCustomerId(3);
		 System.out.println(customer1.getCustId()+customer1.getName()+customer1.getAge());
		 Customer customerA = customerDAO.findByCustomerId(1);
		 System.out.println("Customer A : " + customerA.getCustId());
		
		 Customer customerB = customerDAO.findByCustomerId(2);
		 System.out.println("Customer B : " + customerB.getCustId());
		
		 List<Customer> customerAs = customerDAO.findAll();
		 for(Customer cust: customerAs){
		 System.out.println("Customer As : " + cust.getCustId());
		 }
		
		 String customerName = customerDAO.findCustomerNameById(1);
		 System.out.println("Customer Name : " + customerName);
		//
		// int total = customerDAO.findTotalCustomer();
		// System.out.println("Total : " + total);
//        Customer customer1 = new Customer(4, "yiibai1",21);
//        Customer customer3 = new Customer(5, "yiibai2",22);
//        Customer customer2 = new Customer(6, "yiibai3",23);
//  
//        List<Customer>customers = new ArrayList<Customer>();
//        customers.add(customer1);
//        customers.add(customer2);
//        customers.add(customer3);
//        
//        customerDAO.insertBatch(customers);
        
//        String sql = "UPDATE CUSTOMER SET NAME ='BATCHUPDATE'";
//        customerDAO.insertBatchSQL(sql);
	}
}
