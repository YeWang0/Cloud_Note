package com.ud.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.NoteService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class cancelFavController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/cancelfav.do")
	@ResponseBody
	public NoteResult execute(String favId){
		NoteResult result = noteService.cancelFavorite(favId);
		return result;
	}
}
