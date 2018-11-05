package com.davielucas.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity (name="user")
@NamedQueries(value = { @NamedQuery(name = "user.findByEmailPassword",
query = "SELECT c FROM user c "
                   + "WHERE c.email = :email AND c.password = :password")})
@Table	(name="users")
public class User {
	
	private static final long serialVersionUID = 1L;
	
	@Transient
    public static final String FIND_BY_EMAIL_SENHA = "user.findByEmailPassword";
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_id_user",nullable=false,unique=true)
	private int pkIdUser;
	@Column(name="email",nullable=false,unique=false)
	private String email;
	@Column(name="password",nullable=false,unique=false)
	private String password;
	
}
