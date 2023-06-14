package com.kyle.midnightsuns.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.midnightsuns.models.Ability;
import com.kyle.midnightsuns.repositories.AbilityRepository;

@Service
public class AbilityService {
	private final AbilityRepository abilityRepo;

	public AbilityService(AbilityRepository abilityRepo) {
		this.abilityRepo = abilityRepo;
	}
	
	public List<Ability> getAll(){
		return abilityRepo.findAll();
	}
	
	public Ability create(Ability ability) {
		return abilityRepo.save(ability);
	}
	
	public Ability getOne(Long id) {
		Optional<Ability> optionalAbility =  abilityRepo.findById(id);
		if(optionalAbility.isPresent() ){
			return optionalAbility.get();
		}
		return null;
	}
	
	public Ability getOne(String name) {
		Optional<Ability> optionalAbility = abilityRepo.findByName(name);
		return optionalAbility.isPresent() ? optionalAbility.get() : null;
	}
	
	public Ability update(Ability ability) {
		return abilityRepo.save(ability);
	}
	
	public String delete(Long id) {
		abilityRepo.deleteById(id);
		return id + " has been deleted";
	}

}
