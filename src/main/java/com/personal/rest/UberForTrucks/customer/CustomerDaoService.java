package com.personal.rest.UberForTrucks.customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerDaoService {
	
	private static List<Customer> customers = new ArrayList<Customer>();
	
	private static int customerCount = 3;
	static {
		customers.add(new Customer(1,"Android","android@gmail.com","901-901-9091","street address","APT #","Seattle","WA","98121"));
		customers.add(new Customer(2,"Apple","apple@gmail.com","801-901-9091","street address","APT #","Seattle","WA","98221"));
	}
	
	//findAllCustomers()
	public List<Customer> findAll(){
		return customers;
	}
	
	
	//saveCustomer()
	public Customer save(Customer customer) {
		if(customer.getId()==null) {
			customer.setId(++customerCount );
		}
		customers.add(customer);
		return customer;
	}
	
	
	//findOneCustomer()
	public Customer findOne(int id) {
		for(Customer customer: customers) {
			if(customer.getId()==id) {
				return customer;
			}
		}
		return null;
	}
	
	
	public Customer deleteById(int id) {
		Iterator<Customer> iterator = customers.iterator();
		while(iterator.hasNext()) {
			Customer customer = iterator.next();
			if(customer.getId()==id) {
				iterator.remove();
				return customer;
			}
		}
		return null;
	}
	
}
