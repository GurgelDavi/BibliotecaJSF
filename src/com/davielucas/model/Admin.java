package com.davielucas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity (name="admin")
@Table	(name="admins")
public class Admin {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id",nullable=false,unique=true)
	private int adminId;
	@OneToOne
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
}
