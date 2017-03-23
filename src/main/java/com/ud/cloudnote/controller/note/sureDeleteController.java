package com.ud.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.NoteService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class sureDeleteController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/trash/sure_delete.do")
	@ResponseBody
	public NoteResult sureDelete(String noteId){
		NoteResult result =
				noteService.sureDelete(noteId);
		return result;
	}

}
