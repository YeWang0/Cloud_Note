package com.ud.cloudnote.service;

import com.ud.cloudnote.util.NoteResult;

public interface BookService {
	public NoteResult addBook(
			String userId,String name);
	public NoteResult loadUserBooks(String userId);
	public NoteResult updateBookName(String userId, String bookId, String name);
}
