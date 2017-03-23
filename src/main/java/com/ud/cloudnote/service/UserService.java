package com.ud.cloudnote.service;

import com.ud.cloudnote.util.NoteResult;

public interface UserService {
	public NoteResult addUser(
		String name,String nick,String password);
	public NoteResult checkLogin(
		String name,String password);
	public NoteResult changePwd(String userId,String opwd,String npwd);
}
