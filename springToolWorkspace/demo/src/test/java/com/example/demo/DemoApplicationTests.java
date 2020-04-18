package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Link;
import com.example.demo.functionality.UrlParser;
import com.example.demo.services.LinkService;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	LinkService linkService;


	@Test
	void extractLinksTest() throws IOException {
		UrlParser urlParser= new UrlParser();
		String site = "https://www.google.com/search?rlz=1C1GCEB_enDE858DE858&biw=1280&bih=610&sxsrf=ALeKk00dD3VuEMvz0MW5smCRBUB8-_pNng%3A1586632301762&ei=bRaSXruMLp6MwPAPuKyfkAE&q=how+to+get+external+links&oq=how+to+get+external+links&gs_lcp=CgZwc3ktYWIQAzIECCMQJzIECCMQJzIECCMQJzICCAAyAggAMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeMgYIABAWEB46BAgAEEc6BwgjEOoCECc6BQgAEJECOgUIABDLAToICAAQFhAKEB5KLwgXEiswZzEzNmcxMDVnMTAzZzk4ZzEyM2c5MGc4NWc4OWcxMTZnMTAyZzg5Zzg1Sh0IGBIZMGcxZzFnMWcxZzFnMWcxZzFnMWc1ZzVnN1Dg7glYm74KYLLPCmgBcAF4AIABhAGIAc4SkgEEMTcuOJgBAKABAaoBB2d3cy13aXqwAQo&sclient=psy-ab&ved=0ahUKEwj79vD1ieHoAhUeBhAIHTjWBxIQ4dUDCAw&uact=5";
	    List<Link> links = urlParser.extractLinks(site);
	    for (Link link : links) {
	      System.out.println(link);
	    }
	}
	
	@Test
	void existsDomainTest() {
		Boolean existsDomain= linkService.domainExists("www.google.com");
		System.out.println(existsDomain);
	}
	

	@Test
	void getListOfLinksTest() {
		
		List<Link> linkList= linkService.getLinks("www.google.com");
		System.out.println(linkList.size());
		for(Link l: linkList) {
			System.out.println(l);
		}
		
	}
	
	@Test
	void addLinks() {
		
		linkService.handleLinks("https://www.google.ro");
		
	}
}
