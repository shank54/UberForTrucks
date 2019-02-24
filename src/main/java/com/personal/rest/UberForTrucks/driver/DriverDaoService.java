package com.personal.rest.UberForTrucks.driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DriverDaoService {
	
	private static List<Driver> drivers = new ArrayList<Driver>();
	
	private static int driverCount = 3;
	static {
		drivers.add(new Driver(1,"Android","android@gmail.com","901-901-9091","street address","APT #","Seattle","WA","98121"));
		drivers.add(new Driver(2,"Apple","apple@gmail.com","801-901-9091","street address","APT #","Seattle","WA","98221"));
	}
	
	//findAllCustomers()
	public List<Driver> findAll(){
		return drivers;
	}
	
	
	//saveCustomer()
	public Driver save(Driver driver) {
		if(driver.getId()==null) {
			driver.setId(++driverCount );
		}
		drivers.add(driver);
		return driver;
	}
	
	
	//findOneDriver()
	public Driver findOne(int id) {
		for(Driver driver: drivers) {
			if(driver.getId()==id) {
				return driver;
			}
		}
		return null;
	}
	
	
	public Driver deleteById(int id) {
		Iterator<Driver> iterator = drivers.iterator();
		while(iterator.hasNext()) {
			Driver driver = iterator.next();
			if(driver.getId()==id) {
				iterator.remove();
				return driver;
			}
		}
		return null;
	}
	
}
