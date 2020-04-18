package com.example.demo.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entities.Domain;
import com.example.demo.entities.Link;

public interface LinkRepository extends PagingAndSortingRepository<Link, Integer> {
	
	List<Link> findAllByDomain(Domain domain);
	
}
