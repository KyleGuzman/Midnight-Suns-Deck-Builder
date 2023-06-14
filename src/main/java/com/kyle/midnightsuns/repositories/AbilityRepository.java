package com.kyle.midnightsuns.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.midnightsuns.models.Ability;

@Repository
public interface AbilityRepository extends CrudRepository<Ability, Long> {
	List<Ability> findAll();
	Optional<Ability> findByName(String name);
}
