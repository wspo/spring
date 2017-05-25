package com.wspo.springJDBC.customer.dao;

import java.util.List;

import com.wspo.springJDBC.customer.model.Customer;

public interface CustomerDAO {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public List<Customer> findAll();
	public int findTotalCustomer();
	public String findCustomerNameById(int i);
	public void insertBatch(List<Customer> customers);
	public void insertBatchSQL(String sql);
}
