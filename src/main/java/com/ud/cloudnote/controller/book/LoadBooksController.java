package com.ud.cloudnote.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.BookService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class LoadBooksController {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/book/loadbooks.do")
	@ResponseBody
	public NoteResult loadBooksController(String userId){
		NoteResult result = 
		bookService.loadUserBooks(userId);
		return result;
	}
	
}
