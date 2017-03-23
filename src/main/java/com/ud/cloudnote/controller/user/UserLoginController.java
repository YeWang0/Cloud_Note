package com.ud.cloudnote.controller.user;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.cloudnote.service.UserService;
import com.ud.cloudnote.util.NoteResult;
@Controller//扫描
public class UserLoginController {
	@Resource//注入
	private UserService userService;
	@RequestMapping("/user/login.do")
	@ResponseBody
	public NoteResult userLoginController(
		String name,String password){
		System.out.println("go /user/login.do");
		NoteResult result = 
			userService.checkLogin(
				name, password);
		return result;
	}
	
}
