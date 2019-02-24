package com.personal.rest.UberForTrucks.driver;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.personal.rest.UberForTrucks.order.Order;

@Entity
public class Driver {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Name should have atleast two characters")
	private String name;
	
	@NotEmpty
	@NotEmpty(message = "Email is mandatory.")
    @Email
	private String email;
	
	private String phone;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	
//	private String currentAddress1;
//	private String currentAddress2;
//	private String currentCity;
//	private String currentState;
//	private String currentZipCode;
	
	
	
	@OneToMany(mappedBy="driver")
	private List<Order> orders;

	protected Driver() {}
	
	public Driver(Integer id, String name, String email, String phone, String address1, String address2, String city,
			String state, String zipCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ "]";
	}
	
	
}
