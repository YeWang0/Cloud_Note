package com.ud.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.NoteService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class SearchShareNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/note/search_share")
	@ResponseBody
	public NoteResult execute(String keyword,int page){
		NoteResult result = 
		noteService.searchShareNote(keyword,page);
		return result;
	}
	
}
