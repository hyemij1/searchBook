package com.example.searchBook.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.searchBook.User.model.User;
import com.example.searchBook.User.service.UserService;
import com.example.searchBook.book.model.History;
import com.example.searchBook.book.model.Recent;
import com.example.searchBook.book.service.HistoryService;

@Controller
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/history")
	@ResponseBody
	public List<History> history(Principal principal, Model model) {

		User loginuser = userService.findByUsername(principal.getName());

		return historyService.findByUserId(loginuser.getId());
	}

	@GetMapping(value = "/recent")
	@ResponseBody
	public List<Recent> recent(Principal principal, Model model) {
		return historyService.findRecent();
	}

}
