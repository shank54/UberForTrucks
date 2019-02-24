package com.personal.rest.UberForTrucks.driver;

import java.net.URI;
import java.util.List;
import java.util.Optional;


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
public class DriverResource {
		
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/drivers")
	public List<Driver> retrieveAllDrivers(){
		return driverRepository.findAll();
	}
	
	@GetMapping("/drivers/{id}")
	public Optional<Driver> retrieveDriver(@PathVariable int id) {
		 Optional<Driver> driver = driverRepository.findById(id);
		 if(!driver.isPresent()) {
			 throw new DriverNotFoundException("id- "+id);
		 }
		 return driver;
	}
	
	@DeleteMapping("/drivers/{id}")
	public void deleteDriver(@PathVariable int id) {
		driverRepository.deleteById(id);
	}
	
	//This method should be used to get current address of driver and return list of orders in radius.
//	@PostMapping("/drivers")
//	public ResponseEntity<Object> createDriver(@Valid @RequestBody Driver driver) {
//		Driver savedDriver = driverRepository.save(driver);
//		
//		URI location = ServletUriComponentsBuilder
//											.fromCurrentRequest()
//											.path("/{id}")
//											.buildAndExpand(savedDriver.getId())
//											.toUri();
//		
//		return ResponseEntity.created(location).build();
//		
//	}
	
	
	@GetMapping("/drivers/{id}/orders")
	public List<Order> retrieveAllOrders(@PathVariable int id){
		Optional<Driver> driverOptional = driverRepository.findById(id);
		
		if(!driverOptional.isPresent()) {
			throw new DriverNotFoundException("id- "+id);
		}
		
		return driverOptional.get().getOrders();	
	}
	
	// When the driver selects the order. Add the orders to Drivers list.
	
	
	
	// This is not required.
//	@PostMapping("/drivers/{id}/orders")
//	public ResponseEntity<Object> createOrder(@PathVariable int id, @RequestBody Order order) {
//		Optional<Driver> driverOptional = driverRepository.findById(id);
//		
//		if(!driverOptional.isPresent()) {
//			throw new DriverNotFoundException("id- "+id);
//		}
//		
//		Driver driver = driverOptional.get();
//		
//		order.setDriver(driver);
//		
//		orderRepository.save(order);
//		
//		URI location = ServletUriComponentsBuilder
//											.fromCurrentRequest()
//											.path("/{id}")
//											.buildAndExpand(order.getId())
//											.toUri();
//		
//		return ResponseEntity.created(location).build();
//		
//	}
	
	
}
