package com.ase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ase.model.User;
import com.ase.repository.UserRepository;

@Controller
public class AuthenticationController {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String getUserLogin(Model model) {

		return "LoginPage";

	}

	@GetMapping("/register")
	public String getSignUp(Model model) {

		model.addAttribute("hPage", new User());
		return "signup";

	}
	/*
	 * @GetMapping("/home") public String getLandingUp(Model model) {
	 * 
	 * model.addAttribute("hPage", new User()); return "redirect:/home";
	 * 
	 * }
	 */
	
	@PostMapping("/addUser")
	public String registerUsers(@ModelAttribute User user, Model model) {
		model.addAttribute("hPage", new User());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return "redirect:/user/home";
	}

}
