package com.kyle.midnightsuns.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kyle.midnightsuns.services.BuildService;
import com.kyle.midnightsuns.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	private final UserService userServ;
	private final BuildService buildServ;
	public HomeController(UserService userServ, BuildService buildServ) {
		this.userServ = userServ;
		this.buildServ = buildServ;
	}
	
	@GetMapping("/")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("user_id") != null) {
			model.addAttribute("loggedInUser", userServ.getUser((Long)session.getAttribute("user_id")));
		}
		model.addAttribute("allBuilds", buildServ.getAll());
		return "main/dashboard.jsp";
	}

}
