package com.personal.rest.UberForTrucks.order;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personal.rest.UberForTrucks.customer.Customer;
import com.personal.rest.UberForTrucks.driver.Driver;

@Entity
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue
	private Integer order_id;
	
	private String CustomerName;
	private String DriverName;
	private Integer quantity;
	private Double height;
	private Double weight;
	private String description;
	private Double length;
	private String packageName;
	
	private String ToName;
	private String ToAddress1;
	private String ToAddress2;
	private String ToCity;
	private String ToState;
	private String ToZipCode;
	private String status;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Customer customer;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Driver driver;

	@OneToOne(mappedBy = "p_order")
	private Payment payment;

	public Integer getId() {
		return order_id;
	}

	public void setId(Integer id) {
		this.order_id = id;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getToName() {
		return ToName;
	}

	public void setToName(String toName) {
		ToName = toName;
	}

	public String getToAddress1() {
		return ToAddress1;
	}

	public void setToAddress1(String toAddress1) {
		ToAddress1 = toAddress1;
	}

	public String getToAddress2() {
		return ToAddress2;
	}

	public void setToAddress2(String toAddress2) {
		ToAddress2 = toAddress2;
	}

	public String getToCity() {
		return ToCity;
	}

	public void setToCity(String toCity) {
		ToCity = toCity;
	}

	public String getToState() {
		return ToState;
	}

	public void setToState(String toState) {
		ToState = toState;
	}

	public String getToZipCode() {
		return ToZipCode;
	}

	public void setToZipCode(String toZipCode) {
		ToZipCode = toZipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Order [id=" + order_id + ", CustomerName=" + CustomerName + ", DriverName=" + DriverName + ", quantity="
				+ quantity + ", height=" + height + ", weight=" + weight + ", description=" + description + ", length="
				+ length + ", packageName=" + packageName + ", ToName=" + ToName + ", ToAddress1=" + ToAddress1
				+ ", ToAddress2=" + ToAddress2 + ", ToCity=" + ToCity + ", ToState=" + ToState + ", ToZipCode="
				+ ToZipCode + "]";
	}
	
}
