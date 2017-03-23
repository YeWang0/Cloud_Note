package com.ud.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.NoteService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class AddFavoriteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/favorite.do")
	@ResponseBody
	public NoteResult addToFavoriteController(String userId,String shareId){
		NoteResult result = noteService.addToFavorite(shareId, userId);
		return result;
	}
}
