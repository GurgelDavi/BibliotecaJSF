package com.davielucas.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.davielucas.controller.ResourcePersistence;
import com.davielucas.model.Admin;
import com.davielucas.model.User;

public class AdminsDAO {
	public void create(User obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		Admin adm = new Admin();
		adm.setUser(obj);
		try {
			em.getTransaction().begin();
			em.persist(adm);
			em.getTransaction().commit();
			System.out.println(obj.getEmail()+" is admin now");
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public List read() {
		EntityManager em = ResourcePersistence.getEntityManager();
		List<Admin> adms = new ArrayList<Admin>();
		try {
			em.getTransaction().begin();
			adms = em.createQuery("SELECT a FROM admin a").getResultList();
			em.getTransaction().commit();
			return adms;
		} catch (Exception e) {
			System.err.println("read() exception" + e.getMessage());
			return null;
		} finally {
			em.close();
		}
		
	}
	
	public Admin read(User obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		Admin adm = new Admin();
		try {
			adm = (Admin) em.createQuery(
					"SELECT a FROM admin a where a.user = :userId ")
					.setParameter("userId", obj)
					.getSingleResult();
			
			System.out.println("Encontrado " + obj.getEmail());
			return adm;
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
			return null;
		} finally {
			em.close();
		}
		
	}
	
	public void update(Admin obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			System.out.println("Alterado "+obj.getUser().getEmail());
		} catch (Exception e) {
			System.err.println("Exception em AdminsDAO Update " + e.getMessage());
		}finally {
			em.close();
		}
	}
	
	public void delete(Admin obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		Admin c ;
		try {
			em.getTransaction().begin();
			c= em.merge(obj);
			em.remove(c);
			em.getTransaction().commit();
			System.out.println("removido "+obj.getUser().getEmail());
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		}finally {
			em.close();
		}
	}
	
	
}
