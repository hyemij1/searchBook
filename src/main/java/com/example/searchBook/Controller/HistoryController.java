package com.example.searchBook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.searchBook.book.model.History;
import com.example.searchBook.book.service.HistoryService;

@Controller
public class HistoryController {

	@Autowired
	private HistoryService historyService;
	
	@GetMapping(value = "/history")
	@ResponseBody
	public List<History> history(Model model) {
		return historyService.findByUserId(3L);
	}
	
}
