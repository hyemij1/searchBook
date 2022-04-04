package com.example.searchBook.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.searchBook.book.model.History;
import com.example.searchBook.book.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryRepository historyRepository;

	@Override
	public List<History> findByUserId(Long userId) {
		return historyRepository.findByUserId(userId);
	}
	
	@Transactional
	@Override
	public void saveHistory(History history) {
		historyRepository.saveHistory(history);
	}

}
