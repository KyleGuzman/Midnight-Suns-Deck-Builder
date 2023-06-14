package com.kyle.midnightsuns.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyle.midnightsuns.models.Build;

@Repository
public interface BuildRepository extends CrudRepository<Build, Long> {
	List<Build> findAll();
}
