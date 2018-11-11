package com.davielucas.view;

import com.davielucas.impl.AdminsDAO;
import com.davielucas.impl.UserDaoImpl;
import com.davielucas.model.Admin;
import com.davielucas.model.User;

public class PopulateBank {
	public void populate() {
		UserDaoImpl dao = new UserDaoImpl();
//		User usu1 = new User();
//		usu1.setEmail("testinho@teste.com");
//		usu1.setPassword("123456");
//		
		User usu2 = new User();
//		dao.create(usu1);
//		
//		usu2.setEmail("davi@teste.com");
//		usu2.setPassword("123456");
//		dao.create(usu2);
//		BookDAO bDao = new BookDAO();
//		Book book1 = new Book();
//		book1.setAuthor("Machado de Assis");
//		book1.setAvailable(true);
//		book1.setEdition("3a Edição");
//		book1.setPublisher("Martin Claret");
//		book1.setTitle("Memórias Póstumas de Brás Cubas");
//		bDao.create(book1);
//		
//		Book book2 = new Book();
//		book2.setAuthor("Jane Ausen");
//		book2.setAvailable(true);
//		book2.setEdition("Edição de Luxo");
//		book2.setPublisher("Martin Claret");
//		book2.setTitle("Orgulho e Preconceito");
//		bDao.create(book2);
//		
//		Book book3 = new Book();
//		book3.setAuthor("John Leguizamo");
//		book3.setAvailable(true);
//		book3.setEdition("1a Edição");
//		book3.setPublisher("Tarso Publisher");
//		book3.setTitle("The Pest");
//		bDao.create(book3);
		AdminsDAO aDao = new AdminsDAO();
		usu2 = dao.getUserByEmail("davi@teste.com");
		aDao.create(usu2);
	}
	
}
