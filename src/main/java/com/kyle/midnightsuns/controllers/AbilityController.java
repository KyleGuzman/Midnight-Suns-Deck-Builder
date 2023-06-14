package com.kyle.midnightsuns.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kyle.midnightsuns.models.Ability;
import com.kyle.midnightsuns.services.AbilityService;

@RestController
@RequestMapping("/ability")
public class AbilityController {
	private final AbilityService abilityServ;

	public AbilityController(AbilityService abilityServ) {
		this.abilityServ = abilityServ;
	}

	@GetMapping("")
	public List<Ability> findAllAbilities() {
		return abilityServ.getAll();
	}

	@PostMapping("")
	public Ability createAbility(@RequestParam("hero") String hero, @RequestParam("name") String name,
			@RequestParam("type") String type, @RequestParam("description") String description,
			@RequestParam("damage") String damage, @RequestParam("heroism") String heroism) {
		Ability newAbility = new Ability(hero, name, type, description, damage, heroism);
		return abilityServ.create(newAbility);

	}

	@GetMapping("/{id}")
	public Ability findOneAbility(@PathVariable("id") Long id) {
		return abilityServ.getOne(id);
	}

	@PutMapping("/{id}")
	public Ability updateAbility(@PathVariable("id") Long id, @RequestParam("hero") String hero, @RequestParam("name") String name,
			@RequestParam("type") String type, @RequestParam("description") String description,
			@RequestParam("damage") String damage, @RequestParam("heroism") String heroism, @RequestParam("mods") ArrayList<String> mods) {
		Ability abilityToBeUpdated = new Ability(hero, name, type, description, damage, heroism, mods);
		abilityToBeUpdated.setId(id);
		return abilityServ.update(abilityToBeUpdated);
	}

	@DeleteMapping("/{id}")
	public String deleteAbility(@PathVariable("id") Long id) {
		return abilityServ.delete(id);
	}

}
