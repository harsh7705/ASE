package com.ase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserContoller {

	@PostMapping("/home")
	public String getUserHome(Model model) {
		return "home";
	}

}
