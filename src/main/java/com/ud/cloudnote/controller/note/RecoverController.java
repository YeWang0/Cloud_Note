package com.ud.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.NoteService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class RecoverController {

	@Resource
	private NoteService noteService;
	@RequestMapping("/trash/recover.do")
	@ResponseBody
	public NoteResult noteRecover(String noteId){
		NoteResult result = noteService.noteRecover(noteId);
		return result;
	}
}
