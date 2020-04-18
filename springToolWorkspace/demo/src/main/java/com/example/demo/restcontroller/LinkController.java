package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Link;
import com.example.demo.services.LinkService;


@RestController
public class LinkController {
	
    @Autowired
	LinkService linkService;
    
    @CrossOrigin(origins = "http://localhost:8090")
    @PostMapping(path="/link")
    public List<Link> handleUrl(String url){
    	System.out.println("works");
    	
    	return linkService.handleLinks(url);	
    } 
    
}
