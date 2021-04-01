package com.ase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobContoller {

	@GetMapping("/jobs")
	public String getJobs(Model model) {
		return "jobs";
	}

	@GetMapping("/team")
	public String getUserHome(Model model) {
		return "team";
	}
}
