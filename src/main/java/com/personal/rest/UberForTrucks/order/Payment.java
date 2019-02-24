package com.personal.rest.UberForTrucks.order;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue
	private Integer payment_id;
	private String nameOnCard;
	private String cardNumber;
	private String month;
	private String year;
	private Integer cvv;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Order p_order;

	public Integer getId() {
		return payment_id;
	}

	public void setId(Integer id) {
		this.payment_id = id;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Order getOrder() {
		return p_order;
	}

	public void setOrder(Order order) {
		this.p_order = order;
	}

	@Override
	public String toString() {
		return "Payment [id=" + payment_id + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber + ", month=" + month
				+ ", year=" + year + ", cvv=" + cvv + "]";
	}
	
	
	
}
