package com.davielucas.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.davielucas.controller.ResourcePersistence;
import com.davielucas.model.Admin;
import com.davielucas.model.Book;
import com.davielucas.model.Rent;
import com.davielucas.model.User;

public class RentDAO {
	public void create(User obj,Book obj2) {
		EntityManager em = ResourcePersistence.getEntityManager();
		Rent rent = new Rent();
		rent.setUser(obj);
		rent.setBook(obj2);
		try {
			em.getTransaction().begin();
			em.persist(rent);
			em.getTransaction().commit();
			System.out.println(obj.getEmail()+"requested rent for" + obj2.getTitle());
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		} finally {
			em.close();
		}
	}	
	@SuppressWarnings("unchecked")
	public List rentsRequest() {
		EntityManager em = ResourcePersistence.getEntityManager();
		List<Rent> rentsRequest = new ArrayList<Rent>();
		try {
			em.getTransaction().begin();
			rentsRequest = em.createQuery("SELECT r FROM rent r where r.admin = :adminId")
					.setParameter("adminId", null)
					.getResultList();
			em.getTransaction().commit();
			return rentsRequest;
		} catch (Exception e) {
			System.err.println("rentsRequest() exception" + e.getMessage());
			return null;
		} finally {
			em.close();
		}
		
	}
	
	public List read(User obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		List<Rent> rent = new ArrayList<Rent>();
		try {
			rent = em.createQuery(
					"SELECT r FROM rent r where r.user = :userId ")
					.setParameter("userId", obj)
					.getResultList();
			
			System.out.println("Found rents for User " + obj.getEmail());
			return rent;
		} catch (Exception e) {
			System.err.println("ReadUser " + e.getMessage());
			return null;
		} finally {
			em.close();
		}	
	}
	
	public List read(Admin obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		List<Rent> rent = new ArrayList<Rent>();
		try {
			rent = em.createQuery(
					"SELECT r FROM rent r where r.admin = :adminId ")
					.setParameter("adminId", obj)
					.getResultList();
			
			System.out.println("Found rents conceded from Admin " + obj.getUser().getEmail());
			return rent;
		} catch (Exception e) {
			System.err.println("ReadAdmin " + e.getMessage());
			return null;
		} finally {
			em.close();
		}	
	}
	
	public void concedeRent(Rent obj,Admin obj2) {
		EntityManager em = ResourcePersistence.getEntityManager();
		obj.setAdmin(obj2);
		obj.setRentDate(new Date());
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
	
	public void delete(Rent obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		Rent r ;
		try {
			em.getTransaction().begin();
			r= em.merge(obj);
			em.remove(r);
			em.getTransaction().commit();
			System.out.println("removed "+obj.getUser().getEmail()+" of "
					+ obj.getBook().getTitle()+"conceded by"+obj.getAdmin().getUser());
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		}finally {
			em.close();
		}
	}
}
