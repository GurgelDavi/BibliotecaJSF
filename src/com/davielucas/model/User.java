package com.davielucas.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity (name="user")
@Table	(name="users")
public class User {	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_id_user",nullable=false,unique=true)
	private int pkIdUser;
	@Column(name="email",nullable=false,unique=true)
	private String email;
	@Column(name="password",nullable=false,unique=false)
	private String password;
	

	public int getPkIdUser() {
		return pkIdUser;
	}

	public void setPkIdUser(Integer pkIdUser) {
		this.pkIdUser = pkIdUser;
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
	
}
