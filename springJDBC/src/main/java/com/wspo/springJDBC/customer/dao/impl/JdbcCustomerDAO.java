package com.wspo.springJDBC.customer.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.wspo.springJDBC.customer.dao.CustomerDAO;
import com.wspo.springJDBC.customer.model.Customer;

public class JdbcCustomerDAO extends JdbcDaoSupport implements CustomerDAO {

	public void insert(Customer customer) {

		String sql = "INSERT INTO CUSTOMER " + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { customer.getCustId(), customer.getName(), customer.getAge() });
	}

	public Customer findByCustomerId(int custId) {
		Customer customer = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		customer = (Customer) getJdbcTemplate().queryForObject(sql, new Object[] { custId },new BeanPropertyRowMapper(Customer.class));
		return customer;
	}
	
	public List<Customer> findAll(){
		String sql = "SELECT * FROM CUSTOMER";		 
		List<Customer> customers = new ArrayList<Customer>();
		customers = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Customer.class));
		return customers;
	}
	
	public String findCustomerNameById(int custId){
		
		String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID = ?";
			 
		String name = (String)getJdbcTemplate().queryForObject(
				sql, new Object[] { custId }, String.class);
		
		return name;	
	}
	
	public int findTotalCustomer(){
		
		String sql = "SELECT COUNT(*) FROM CUSTOMER";
			 
		int total = getJdbcTemplate().queryForInt(sql);
					
		return total;
	}
	
	public void insertBatch(final List<Customer> customers){
		
		  String sql = "INSERT INTO CUSTOMER " +
			"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
					
		  getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Customer customer = customers.get(i);
				ps.setLong(1, customer.getCustId());
				ps.setString(2, customer.getName());
				ps.setInt(3, customer.getAge() );
			}

			public int getBatchSize() {
				return customers.size();
			}
					
		  });
		}
	public void insertBatchSQL(final String sql){
		
		getJdbcTemplate().batchUpdate(new String[]{sql});
			
	}
}
