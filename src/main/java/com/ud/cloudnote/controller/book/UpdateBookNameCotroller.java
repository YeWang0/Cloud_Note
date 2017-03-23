package com.ud.cloudnote.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.BookService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class UpdateBookNameCotroller {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/book/updatebookname.do")
	@ResponseBody
	public NoteResult updateBookNameController(String userId,String name, String bookId){
		
		NoteResult result = 
		bookService.updateBookName(userId,bookId,name);
		System.out.println(result.getMsg());
		return result;
	}
}
