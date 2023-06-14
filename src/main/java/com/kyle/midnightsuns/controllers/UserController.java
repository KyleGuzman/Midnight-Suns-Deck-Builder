package com.kyle.midnightsuns.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyle.midnightsuns.models.LoginUser;
import com.kyle.midnightsuns.models.User;
import com.kyle.midnightsuns.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userServ;

	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	@GetMapping("")
	public String loginReg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "user/loginReg.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		if (userServ.getUser(newUser.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email is already in use");
		}

		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "Match", "Passwords do not match");
		}

		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "user/loginReg.jsp";
		}
		User regUser = userServ.createUser(newUser);
		session.setAttribute("user_id", regUser.getId());
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User loggingUser = userServ.login(newLogin, result);
		
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "user/loginReg.jsp";
		}
		
		session.setAttribute("user_id", loggingUser.getId());
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
