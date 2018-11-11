package com.davielucas.view;

import javax.persistence.EntityManager;

import com.davielucas.controller.ResourcePersistence;
import com.davielucas.impl.AdminsDAO;
import com.davielucas.impl.UserDaoImpl;
import com.davielucas.model.User;

public class AtualizaDB {
	public static void main(String[] args) {
//		EntityManager em = ResourcePersistence.getEntityManager();
//		PopulateBank pop = new PopulateBank();
//		pop.populate();
		AdminsDAO admDaotest = new AdminsDAO();
		User usu1 = new User();
		UserDaoImpl usudao = new UserDaoImpl();
		usu1 = usudao.getUserByEmail("davi@teste.com");
		System.out.println(usu1.getEmail());
		if (admDaotest.read(usu1)!=null) {
			System.out.println("Is adm!");
		}
	}
}
