package com.davielucas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name="admin")
@Table	(name="admins")
public class Admins {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id",nullable=false,unique=true)
	private int userId;
}
