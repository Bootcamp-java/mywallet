package com.rst.mywallet.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rst.mywallet.model.Customer;

public class CustomerDTO {

	private long customerId;
	private String firstName;
	private String lastName;
	private String email;
	private Date date;
	private long phoneNumber;
	private String address;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", date=" + date + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}

	// converting entity to DTO
	public static CustomerDTO valueOf(Customer cust) {
		CustomerDTO cusDTO = new CustomerDTO();
		cusDTO.setFirstName(cust.getFirstName());
		cusDTO.setLastName(cust.getLastName());
		cusDTO.setEmail(cust.getEmail());
		cusDTO.setAddress(cust.getAddress());
		cusDTO.setPhoneNumber(cust.getPhoneNumber());
		cusDTO.setDate(cust.getDate());
		return cusDTO;
	}

	// converting DTO to Entity
	public Customer createEntity() {
		Customer cust = new Customer();
		cust.setFirstName(this.getFirstName());
		cust.setLastName(this.getLastName());
		cust.setEmail(this.getEmail());
		cust.setAddress(this.getAddress());
		cust.setPhoneNumber(this.getPhoneNumber());
		cust.setDate(this.getDate());
		return cust;
	}

}
