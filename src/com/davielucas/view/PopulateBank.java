package com.davielucas.view;

import com.davielucas.impl.UserDaoImpl;
import com.davielucas.model.User;

public class PopulateBank {
	public void populate() {
		UserDaoImpl dao = new UserDaoImpl();
		User usu1 = new User();
		usu1.setEmail("testinho@teste.com");
		usu1.setPassword("123456");
		
		User usu2 = new User();
		usu2.setEmail("testinho@teste.com");
		usu2.setPassword("123456");
		dao.create(usu1);
		
		usu2.setEmail("davi@teste.com");
		usu2.setPassword("123456");
		dao.create(usu2);
	}
	
}
