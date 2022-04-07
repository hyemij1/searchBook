package com.example.searchBook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.searchBook.User.model.User;
import com.example.searchBook.User.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "login/registration";
	}

	@PostMapping(value = "/registration")
	public String registration(@ModelAttribute("userForm") User userForm, Model model, RedirectAttributes ra) {
		try {
			userService.saveUser(userForm);
			return "home";
		} catch (Exception e)	{
			ra.addFlashAttribute("errorMessage", e.getMessage());
			return "redirect:registration";
		}

	}
}
