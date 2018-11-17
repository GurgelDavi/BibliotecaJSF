package com.davielucas.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.davielucas.controller.ResourcePersistence;
import com.davielucas.model.Book;

public class BookDAO {
	
	public List<Book> get() {
		
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			em.getTransaction().begin();
			//TypedQuery<Book> query = em.createNamedQuery("SELECT * FROM books", Book.class);
			List books = new ArrayList<Book>();
			books = em.createQuery("SELECT b FROM book b").getResultList();
			em.getTransaction().commit();
			return books;
			
			//return //query.getResultList();
			
			
		} catch (Exception e) {
			System.out.println("BookDAO.get() exception: " + e.getMessage());
			return null;
			
		} finally {
			em.close();
		}
	}

	public List<Book> getDue() {
		
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			em.getTransaction().begin();
			//TypedQuery<Book> query = em.createNamedQuery("SELECT * FROM books", Book.class);
			List books = new ArrayList<Book>();
			books = em.createQuery("SELECT b FROM book b where b.available IS FALSE").getResultList();
			
			em.getTransaction().commit();
			return books;
			
			//return //query.getResultList();
			
			
		} catch (Exception e) {
			System.out.println("BookDAO.get() exception: " + e.getMessage());
			return null;
			
		} finally {
			em.close();
		}
	}
	
	
	
	public Book get(int bookId) {
		
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			Book book = em.find(Book.class, bookId);
			return book;
			
		} catch (Exception e) {
			System.out.println("BookDAO.get(bookId) exception: " + e.getMessage());
			return null;
			
		} finally {
			em.close();
		}
	}
	
	
	public boolean create(Book newBook) {
		
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(newBook);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			System.out.println("BookDAO.create(newBook) exception: " + e.getMessage());
			return false;
			
		} finally {
			em.close();
		}
	}

	
	public boolean update(Book newBook) {
		
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			Book book = em.find(Book.class, newBook.getBookId());
			em.getTransaction().begin();
			book.setAuthor(newBook.getAuthor());
			book.setAvailable(newBook.getAvailable());
			book.setEdition(newBook.getEdition());
			book.setPublisher(newBook.getPublisher());
			book.setTitle(newBook.getTitle());
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			System.out.println("BookDAO.create(newBook) exception: " + e.getMessage());
			return false;
			
		} finally {
			em.close();
		}
	}
	
	
	public boolean delete(int bookId) {
		
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			Book book = em.find(Book.class, bookId);
			em.getTransaction().begin();
			em.remove(book);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			System.out.println("BookDAO.create(newBook) exception: " + e.getMessage());
			return false;
			
		} finally {
			em.close();
		}
	}
}
