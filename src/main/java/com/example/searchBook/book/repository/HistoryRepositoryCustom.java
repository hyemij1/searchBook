package com.example.searchBook.book.repository;

import java.util.List;

import com.example.searchBook.book.model.History;
import com.example.searchBook.book.model.Recent;

public interface HistoryRepositoryCustom {
	
	List<History> findByUserId(Long userId);
	
	void saveHistory(History history);
	
	List<Recent> findRecent();

}
