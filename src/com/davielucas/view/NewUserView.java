package com.davielucas.view;

import javax.faces.bean.ManagedBean;

import com.davielucas.impl.AdminsDAO;
import com.davielucas.impl.UserDaoImpl;
import com.davielucas.model.User;

@ManagedBean
public class NewUserView {

	String email    = "";
	String password = "";
	boolean isAdmin = false;

	public String persist() {
		System.out.println("newUserView.persist()");
		System.out.println("isAdmin: " + isAdmin);
		if (this.isAdmin)
			return this.persistAdmin();
		else 
			return this.persistuser();
	}
	
	private String persistAdmin() {
		System.out.println("newUserView.persistAdmin()");
		this.persistuser();
		
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.getUserByEmail(email);
		
		if (user == null) {
			this.email    = "";
			this.password = "";
			this.isAdmin  = false;
			return "/newUser.xhtml";
		}
		
		AdminsDAO adminDao = new AdminsDAO();
		adminDao.create(user);
		
		return "/login.xhtml?faces-redirect=true";
	}
	
	private String persistuser() {
		UserDaoImpl userDao = new UserDaoImpl();
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		userDao.create(user);
		
		return "/login.xhtml?faces-redirect=true";
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

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
