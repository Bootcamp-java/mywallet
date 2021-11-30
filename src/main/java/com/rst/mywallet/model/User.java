package com.rst.mywallet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 618755863572831158L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, name = "user_id")
	private Long userId;

	@Column(nullable = false, name = "user_name", length = 45)
	private String userName;

	@Column(nullable = false, name = "user_type", length = 45)
	private String userType;

	@Column(name = "user_enabled", nullable = true)
	private boolean userEnabled;

	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@Column(name = "user_email", unique = true, length = 45)
	private String email;

	@Column(name = "user_password", unique = true, length = 64)
	@Transient
	private String password;

	@Column(name = "date_of_birth", unique = true, length = 45)
	private Date date_of_birth;

	@Column(name = "confirmation_token")
	private String confirmationToken;
	
	public User() {

	}

	public User(Long userId, String userName, String userType, boolean userEnabled, Set<Role> roles, String email,
			String password, Date date_of_birth) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.userEnabled = userEnabled;
		this.roles = roles;
		this.email = email;
		this.password = password;
		this.date_of_birth = date_of_birth;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return userEnabled;
	}

	public void setEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	
}
