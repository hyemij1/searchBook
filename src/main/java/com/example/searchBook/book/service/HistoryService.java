package com.example.searchBook.book.service;

import java.util.List;

import com.example.searchBook.book.model.History;

public interface HistoryService {

	List<History> findByUserId(Long userId);
	
	void saveHistory(History history);
	
}
