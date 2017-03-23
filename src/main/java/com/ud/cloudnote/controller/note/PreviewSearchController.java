package com.ud.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.NoteService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class PreviewSearchController {
@Resource
private NoteService noteService;

@RequestMapping("/share/preview.do")
@ResponseBody
public NoteResult execute(String shareId){
	NoteResult result = noteService.previewSearch(shareId);
	System.out.println(result.getMsg());
	return result;
}
}
