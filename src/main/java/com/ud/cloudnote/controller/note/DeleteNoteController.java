package com.ud.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.NoteService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class DeleteNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/note/delete")
	@ResponseBody
	public NoteResult execute(String noteId){
		NoteResult result = 
		  noteService.deleteNote(noteId);
		return result;
	}
	
}
