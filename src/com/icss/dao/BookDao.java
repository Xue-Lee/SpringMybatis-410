package com.icss.dao;

import java.util.List;

import com.icss.entity.Book;

public interface BookDao {
	public List<Book> findBookAll();
	public List<Book> findBookByAuthor(String author);
	public List<Book> findBookByPrice(Float price);
	public List<Book> findBookByPress(String press);
	public List<Book> findBookByPress1(String press);
	public List<Book> findBookByAuthorPrice2(Book book);
	public List<Book> findBookByAuthorPrice3(Book book);
	public int updateBook(Book book);
	public int updateBook1(Book book);
	public List<Book> findBookByPresses1(List<String> presses);
}
