package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Domain;

public interface DomainRepository extends CrudRepository<Domain, Integer> {

	Domain findByName(String name);

	boolean existsByName(String name);

}
