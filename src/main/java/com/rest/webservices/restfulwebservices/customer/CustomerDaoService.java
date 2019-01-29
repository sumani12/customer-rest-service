package com.rest.webservices.restfulwebservices.customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerDaoService  {
	
	private static List<Customer> customers = new ArrayList<>();

	private static int usersCount = 3;

	static {
		customers.add(new Customer(1, "John",  "john@yahoo.com"));
		customers.add(new Customer(2, "Nancy",  "nancy@gmail.com"));
		customers.add(new Customer(3, "Paul",   "paul@yahoo.com"));
	}
	
	public List<Customer> findAll() {
		return customers;
	}

	public Customer save(Customer customer) {
		if (customer.getId() == null) {
			customer.setId(++usersCount);
		}
		customers.add(customer);
		return customer;
	}

	public Customer findOne(int id) {
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}

	public Customer deleteById(int id) {
		Iterator<Customer> iterator = customers.iterator();
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			if (customer.getId() == id) {
				iterator.remove();
				return customer;
			}
		}
		return null;
	}

}
