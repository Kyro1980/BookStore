package com.bookStore.db.tables;

public class Book {
	
	   private int id;
	   private String nameOfBook;
	   private String author;
	   private double price;
	   

	public Book() {
		
	}

	public Book(int id, String nameOfBook, String author, double price) {

		this.id = id;
		this.nameOfBook = nameOfBook;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameOfBook() {
		return nameOfBook;
	}
	public void setNameOfBook(String nameOfBook) {
		this.nameOfBook = nameOfBook;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
