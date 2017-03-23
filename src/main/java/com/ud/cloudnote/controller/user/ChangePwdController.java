package com.ud.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.UserService;
import com.ud.cloudnote.util.NoteResult;

@Controller
public class ChangePwdController {
		@Resource
		private UserService userService;
		
		@RequestMapping("/pwd/changepwd.do")
		@ResponseBody
		public NoteResult changePasswdController(String userId, String opwd, String npwd){
			NoteResult result = 
					userService.changePwd(userId, opwd, npwd);
			return result;
		}
}
