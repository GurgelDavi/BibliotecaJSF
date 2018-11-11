package com.davielucas.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.davielucas.controller.ResourcePersistence;
import com.davielucas.model.User;


public class UserDaoImpl {
	public User getUser(String userEmail,String userPassword) {
		// TODO Auto-generated method stub
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			User user = (User) em.createQuery(
					"SELECT u FROM user u where u.email = :email and u.password = :password")
					.setParameter("email", userEmail)
					.setParameter("password", userPassword).getSingleResult();
			
			System.out.println("Encontrado " + userEmail);
			return user;
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
			return null;
		} finally {
			em.close();
		}
	}
	public User getUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			User user = (User) em.createQuery(
					"SELECT u FROM user u where u.email = :email")
					.setParameter("email", userEmail).getSingleResult();
			
			System.out.println("Encontrado " + userEmail);
			return user;
		} catch (Exception e) {
			System.err.println("getUserByEmail exception " + e.getMessage());
			return null;
		} finally {
			em.close();
		}
	}
	
	
	public void create(User obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			System.out.println("Inserido " + obj.getEmail());
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		} finally {
			em.close();
		}
	}

	public void remove(User obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		User c ;
		try {
			em.getTransaction().begin();
			c= em.merge(obj);
			em.remove(c);
			em.getTransaction().commit();
			System.out.println("removido "+obj.getEmail());
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		}finally {
			em.close();
		}
	}

	public void alter(User obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			System.out.println("Alterado "+obj.getEmail());
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		}finally {
			em.close();
		}
	}
}