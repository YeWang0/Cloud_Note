package com.ud.cloudnote.service;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ud.cloudnote.dao.BookDao;
import com.ud.cloudnote.entity.Book;
import com.ud.cloudnote.util.NoteResult;
import com.ud.cloudnote.util.NoteUtil;

@Service("bookService")
public class BookServiceImpl 
implements BookService{
	@Resource
	private BookDao bookDao;
	
	public NoteResult loadUserBooks(String userId) {
		//按用户ID查询笔记本信息
		List<Book> list = 
			bookDao.findByUserId(userId);
		//创建返回结果
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("Loading Books completed");
		result.setData(list);
		return result;
	}

	public NoteResult addBook(
		String userId, String name) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("bookName", name);
		params.put("userId", userId);
		Book b = bookDao.findByName(params);
		NoteResult result = new NoteResult();
		if(b!=null){
			result.setStatus(1);
			result.setMsg("Notebook has existed");
			return result;
		}else{
		Book book = new Book();
		book.setCn_user_id(userId);//设置用户ID
		book.setCn_notebook_name(name);//设置笔记本名
		String bookId = NoteUtil.createId();
		book.setCn_notebook_id(bookId);//设置笔记本ID
		Timestamp time = new Timestamp(
			System.currentTimeMillis());
		book.setCn_notebook_createtime(time);//设置创建时间
		bookDao.save(book);//保存笔记本
		//创建返回结果
		
		result.setStatus(0);
		result.setMsg("Notebook created");
		result.setData(book);//返回添加的笔记本信息
		return result;
		}
		
	}
	public NoteResult updateBookName(String userId, String bookId, String name){
		Map<String,String> params = new HashMap<String,String>();
		params.put("bookName", name);
		params.put("userId", userId);
		Book b = bookDao.findByName(params);
		NoteResult result = new NoteResult();
		if(b!=null){
			result.setStatus(1);
			result.setMsg("Notebook has existed");
			return result;
		}
		else{
			Book book = new Book();
			book.setCn_user_id(userId);//设置用户ID
			book.setCn_notebook_name(name);//设置笔记本名
			book.setCn_notebook_id(bookId);//设置笔记本ID
			Timestamp time = new Timestamp(
				System.currentTimeMillis());
			book.setCn_notebook_createtime(time);//设置创建时间
			int status=bookDao.updateBookName(book);//update 笔记本
			//创建返回结果
			
			if(status==1){//成功
				result.setStatus(0);
				result.setMsg("Notebook updated");
			}else{//失败
				result.setStatus(1);
				result.setMsg("Notebook updating failed");
			}
			
			return result;
		}
	}
}
