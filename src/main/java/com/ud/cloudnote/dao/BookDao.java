package com.ud.cloudnote.dao;

import java.util.List;
import java.util.Map;

import com.ud.cloudnote.entity.Book;

public interface BookDao {
	public void save(Book book);
	
	public List<Book> findByUserId(
			String userId);
//	public Book findByName(String bookName);
	
	public String getFavId(Map<String,String> param);

	public int updateBookName(Book book);
	public Book findByName(Map<String, String> params);
}
