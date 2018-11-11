package com.davielucas.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import com.davielucas.impl.BookDAO;
import com.davielucas.model.Book;


@ManagedBean(name="bookView")
public class BookView {
	
	private Book selected = new Book();
	private BookDAO cFacetes = new BookDAO();
	
	private String title;
	private String author;
	private String edition;
	private String publisher;
	
	
	public List<Book> getAllBooks() {
		return cFacetes.get();
	}
	
	public String deleteBook(){
		cFacetes.delete(selected.getBookId());
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
	
	public String addNewBook(){
		return "/newBook.xhtml";
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
	
	public String addNewBook(BookView c) {
		Book newBook = new Book();
		newBook.setTitle(this.title);
		newBook.setAuthor(this.author);
		newBook.setEdition(this.edition);
		newBook.setPublisher(this.publisher);
		newBook.setAvailable(true);
		
		cFacetes.create(newBook);
		
		return "/main.xhtml";
	}
}
