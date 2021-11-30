package com.rst.mywallet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	
	@Column(nullable = false , name = "firstName" , length = 45)
	private String firstName;
	
	@Column(nullable = false , name = "lastName" , length = 45)
	private String lastName;
	
	@Column(nullable = false , name = "email" , length = 45)
	private String email;
	
	@Column(nullable = false , name = "date" , length = 45)
	private Date date ;
	
	@Column(nullable = false , name = "phoneNumber" , length = 45)
	private long phoneNumber;
	
	@Column(nullable = false , name = "address" , length = 45)
	private String address;

	public Admin() {
		
	}
	
	public Admin(long adminId, String firstName, String lastName, String email, Date date, long phoneNumber,
			String address) {
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
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
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", date=" + date + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
	
}