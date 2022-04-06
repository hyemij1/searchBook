package com.example.searchBook.book.service;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.searchBook.book.model.History;
import com.example.searchBook.book.model.Recent;

@SpringBootTest
@Transactional
public class HistoryServiceTest {

	@Autowired
	private HistoryService historyService;

	@Test
	void findUser() {

		List<History> historys = historyService.findByUserId(3L);

		System.out.println("##### findUser Test");
		for (History history : historys) {
			System.out.println("history : " + history.getKeyword());
		}
	}

	@Test
	void saveHistory() {

		History history = new History();
		history.setId(null);
		history.setUserId(3L);
		history.setKeyword("날개");
		history.setInputdate(LocalDateTime.now());

		historyService.saveHistory(history);

		List<History> results = historyService.findByUserId(3L);
		if (results.stream().filter(x -> x.getKeyword().equals("날개")).count() > 0) {
			System.out.println("saveHistory save success ");
		} else {
			System.out.println("saveHistory save fail ");
		}

	}

	@Test
	void findRecent() {
		List<Recent> recents = historyService.findRecent();

		System.out.println("##### findRecent Test");
		for (Recent recent : recents) {
			System.out.println("recent : " + recent.getKeyword() + "(" + recent.getCnt() + "회)");
		}
	}

}
