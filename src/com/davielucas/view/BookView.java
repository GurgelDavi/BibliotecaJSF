package com.davielucas.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import com.davielucas.impl.BookDAO;
import com.davielucas.model.Book;


@ManagedBean(name="bookView")
public class BookView {
	private static final long serialVersionUID = 5373823767595263175L;
	
	private Book selected = new Book();
	private String selectedContactId;
	private BookDAO cFacetes = new BookDAO();
	private String title;
	private String author;
	private String edition;
	private String publisher;
	private String id;
	
	
	public List getAllBooks() {
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
	public String getSelectedContactId() {
		return selectedContactId;
	}
	public void setSelectedContactId(String selectedContactId) {
		this.selectedContactId = selectedContactId;
	}
	public BookDAO getcFacetes() {
		return cFacetes;
	}
	public void setcFacetes(BookDAO cFacetes) {
		this.cFacetes = cFacetes;
	}
	public String getTitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		selected.setTitle(c.getTitle());
		selected.setAuthor(c.getAuthor());
		selected.setAvailable(true);
		selected.setEdition(c.getEdition());
		selected.setPublisher(c.getPublisher());
		cFacetes.create(selected);
		return "/main.xhtml";
	}
}
