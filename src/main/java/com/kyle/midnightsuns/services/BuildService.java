package com.kyle.midnightsuns.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kyle.midnightsuns.models.Build;
import com.kyle.midnightsuns.repositories.BuildRepository;

@Service
public class BuildService {
	private final BuildRepository buildRepo;

	public BuildService(BuildRepository buildRepo) {
		this.buildRepo = buildRepo;
	}
	
	public List<Build> getAll(){
		return buildRepo.findAll();
	}
	
	public Build create(Build build) {
		return buildRepo.save(build);
	}
	
	public Build getOne(Long id) {
		Optional<Build> optionalBuild =  buildRepo.findById(id);
		if(optionalBuild.isPresent() ){
			return optionalBuild.get();
		}
		return null;
	}
	
	public Build update(Build build) {
		return buildRepo.save(build);
	}
	
	public String delete(Long id) {
		buildRepo.deleteById(id);
		return id + " has been deleted";
	}

}
