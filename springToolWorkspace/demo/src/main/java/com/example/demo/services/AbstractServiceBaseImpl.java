package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Domain;
import com.example.demo.repos.DomainRepository;
import com.example.demo.repos.LinkRepository;

public abstract class AbstractServiceBaseImpl {
	
	@Autowired
	protected LinkRepository linkRepos;
	
	@Autowired
	protected DomainRepository domainRepos;
	

}
