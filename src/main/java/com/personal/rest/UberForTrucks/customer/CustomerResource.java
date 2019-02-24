package com.personal.rest.UberForTrucks.customer;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.personal.rest.UberForTrucks.order.Order;
import com.personal.rest.UberForTrucks.order.OrderRepository;

@RestController
public class CustomerResource {
		
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Optional<Customer> retrieveCustomer(@PathVariable int id) {
		 Optional<Customer> customer = customerRepository.findById(id);
		 if(!customer.isPresent()) {
			 throw new CustomerNotFoundException("id- "+id);
		 }
		 return customer;
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		 customerRepository.deleteById(id);
	}
	
	//get name and email from sign up. This method returns the location of customer.
	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		
		URI location = ServletUriComponentsBuilder
											.fromCurrentRequest()
											.path("/{id}")
											.buildAndExpand(savedCustomer.getId())
											.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
	@GetMapping("/customers/{id}/orders")
	public List<Order> retrieveAllOrders(@PathVariable int id){
		Optional<Customer> customerOptional = customerRepository.findById(id);
		
		if(!customerOptional.isPresent()) {
			throw new CustomerNotFoundException("id- "+id);
		}
		
		return customerOptional.get().getOrders();	
	}
	
	@PostMapping("/customers/{id}/orders")
	public ResponseEntity<Object> createOrder(@PathVariable int id, @RequestBody Order order) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		
		if(!customerOptional.isPresent()) {
			throw new CustomerNotFoundException("id- "+id);
		}
		
		Customer customer = customerOptional.get();
		
		order.setCustomer(customer);
		
		orderRepository.save(order);
		
		URI location = ServletUriComponentsBuilder
											.fromCurrentRequest()
											.path("/{id}")
											.buildAndExpand(order.getId())
											.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
}
