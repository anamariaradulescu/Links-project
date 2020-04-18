package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Link;

public interface LinkService {
	
	boolean domainExists(String name);
	
	List<Link> getLinks(String domain);
	
	List<Link> handleLinks(String domain);

}
