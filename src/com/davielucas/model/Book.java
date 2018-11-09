package com.davielucas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "book")
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", nullable = false, unique = true)
	private int bookId;
	
	@Column(name = "title", nullable = false, unique = false)
	private String title;
	
	@Column(name = "author", nullable = false, unique = false)
	private String author;
	
	@Column(name = "edition", nullable = false, unique = false)
	private String edition;
	
	@Column(name = "publisher", nullable = false, unique = false)
	private String publisher;
	
	@Column(name = "available", nullable = false, unique = false)
	private boolean available;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
