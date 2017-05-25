package com.wspo.springJDBC.common;

public class Customer {
	private Address address;

	public Customer(Address address) {
		super();
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
