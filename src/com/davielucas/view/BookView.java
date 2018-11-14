package com.davielucas.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import com.davielucas.impl.BookDAO;
import com.davielucas.model.Book;


@ManagedBean
public class BookView {
	
	private Book selected = new Book();
	private BookDAO bookDao = new BookDAO();
	
	private String title;
	private String author;
	private String edition;
	private String publisher;
	
	
	public List<Book> getAllBooks() {
		return bookDao.get();
	}
	
	public String deleteBook(){
		bookDao.delete(selected.getBookId());
		return "/main.xhtml";
	}
	
	public Book getSelected() {
		return selected;
	}
	
	public void setSelected(Book selected) {
		this.selected = selected;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getEdition() {
		return edition;
	}
	
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String createBook() {
		try {
			Book  newBook = new Book();
			newBook.setTitle(this.title);
			newBook.setAuthor(this.author);
			newBook.setEdition(this.edition);
			newBook.setPublisher(this.publisher);
			newBook.setAvailable(true);
			bookDao.create(newBook);
			
		} catch (Exception e) {
			System.out.println("BookView.createBook() exception: "+e.getMessage());
			
		} finally {
			setTitle(null);
			setAuthor(null);
			setEdition(null);
			setPublisher(null);
		}
		
		return "/main.xhtml?faces-redirect=true";
	}
	
}
