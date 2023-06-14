package com.kyle.midnightsuns.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyle.midnightsuns.models.Ability;
import com.kyle.midnightsuns.models.Build;
import com.kyle.midnightsuns.models.User;
import com.kyle.midnightsuns.services.AbilityService;
import com.kyle.midnightsuns.services.BuildService;
import com.kyle.midnightsuns.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/build")
public class BuildController {
	private final BuildService buildServ;
	private final AbilityService abilityServ;
	private final UserService userServ;

	public BuildController(BuildService buildServ, AbilityService abilityServ, UserService userServ) {
		this.buildServ = buildServ;
		this.abilityServ = abilityServ;
		this.userServ = userServ;
	}

	@GetMapping("/create")
	public String createBuild(HttpSession session, Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("newBuild", new Build());
		return "build/create.jsp";
	}

	@PostMapping("/process/create")
	public String processCreateBuild(@Valid @ModelAttribute("newBuild") Build newBuild, BindingResult result,
			Model model, HttpSession session, @RequestParam("ability1") String ability1,
			@RequestParam("modOne") String modOne, @RequestParam("ability2") String ability2,
			@RequestParam("modTwo") String modTwo, @RequestParam("ability3") String ability3,
			@RequestParam("modThree") String modThree, @RequestParam("ability4") String ability4,
			@RequestParam("modFour") String modFour, @RequestParam("ability5") String ability5,
			@RequestParam("modFive") String modFive, @RequestParam("ability6") String ability6,
			@RequestParam("modSix") String modSix, @RequestParam("ability7") String ability7,
			@RequestParam("modSeven") String modSeven, @RequestParam("ability8") String ability8,
			@RequestParam("modEight") String modEight) {
		if (result.hasErrors()) {
			return "build/create.jsp";
		}
		ArrayList<Ability> buildAbilities = new ArrayList<Ability>();
		Ability one = abilityServ.getOne(ability1);
		Ability two = abilityServ.getOne(ability2);
		Ability three = abilityServ.getOne(ability3);
		Ability four = abilityServ.getOne(ability4);
		Ability five = abilityServ.getOne(ability5);
		Ability six = abilityServ.getOne(ability6);
		Ability seven = abilityServ.getOne(ability7);
		Ability eight = abilityServ.getOne(ability8);
		buildAbilities.add(one);
		buildAbilities.add(two);
		buildAbilities.add(three);
		buildAbilities.add(four);
		buildAbilities.add(five);
		buildAbilities.add(six);
		buildAbilities.add(seven);
		buildAbilities.add(eight);
		newBuild.setAbilities(buildAbilities);
		newBuild.setModOne(modOne);
		newBuild.setModTwo(modTwo);
		newBuild.setModThree(modThree);
		newBuild.setModFour(modFour);
		newBuild.setModFive(modFive);
		newBuild.setModSix(modSix);
		newBuild.setModSeven(modSeven);
		newBuild.setModEight(modEight);
		buildServ.create(newBuild);
		return "redirect:/";
	}

	@GetMapping("/{id}")
	public String viewBuild(@PathVariable("id") Long id, Model model, HttpSession session) {
		ArrayList<String> modifiers = new ArrayList<String>();
		Build getMods = buildServ.getOne(id);
		modifiers.add(getMods.getModOne());
		modifiers.add(getMods.getModTwo());
		modifiers.add(getMods.getModThree());
		modifiers.add(getMods.getModFour());
		modifiers.add(getMods.getModFive());
		modifiers.add(getMods.getModSix());
		modifiers.add(getMods.getModSeven());
		modifiers.add(getMods.getModEight());
		model.addAttribute("mods", modifiers);
		model.addAttribute("build", buildServ.getOne(id));
		Build viewBuild = buildServ.getOne(id);
		List<User> votersArr = viewBuild.getVoters();
		boolean canVote = true;
		for (User voted : votersArr) {
			if (voted.getId() == session.getAttribute("user_id")) {
				canVote = false;
			}
		}
		model.addAttribute("canVote", canVote);
		return "build/view.jsp";
	}

	@PutMapping("/vote/{id}")
	public String voteBuild(@PathVariable("id") Long id, Model model, HttpSession session,
			@RequestParam("voters") Long voters) {
		boolean canVote = false;
		model.addAttribute("canVote", canVote);
		ArrayList<String> modifiers = new ArrayList<String>();
		Build getMods = buildServ.getOne(id);
		modifiers.add(getMods.getModOne());
		modifiers.add(getMods.getModTwo());
		modifiers.add(getMods.getModThree());
		modifiers.add(getMods.getModFour());
		modifiers.add(getMods.getModFive());
		modifiers.add(getMods.getModSix());
		modifiers.add(getMods.getModSeven());
		modifiers.add(getMods.getModEight());
		model.addAttribute("mods", modifiers);
		User voter = userServ.getUser(voters);
		Build viewBuild = buildServ.getOne(id);
		Integer currentVotes = viewBuild.getVotes();
		currentVotes++;
		List<User> votersArr = viewBuild.getVoters();
		votersArr.add(voter);
		viewBuild.setVoters(votersArr);
		viewBuild.setVotes(currentVotes);
		buildServ.update(viewBuild);
		model.addAttribute("build", viewBuild);
		return "build/view.jsp";
	}

}
