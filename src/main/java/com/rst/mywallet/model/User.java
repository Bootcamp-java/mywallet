package com.rst.mywallet.model;

import java.io.Serializable;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 618755863572831158L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
	
	@Column(nullable = false , name = "userName" , length = 45)
    private String userName;
	
	@Column(nullable = false ,name = "userType" ,  length = 45)
    private String userType;
	
	@Column(name = "userEnabled", nullable = true)
    private boolean userEnabled;
    
	
	@ManyToMany
	@JoinTable(
			name =  "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns= @JoinColumn(name = "role_id"))
	private Set<Role> roles ;

	@Column(name = "email",unique= true )
	private String email;
	
	@Column(name = "password" , unique= true)
	private String password;
	
	@Column(name = "date_of_birth",unique = true)
	private String date_of_birth;
	
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

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	
}
