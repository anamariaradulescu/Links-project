package com.example.demo.functionality;

import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.apache.commons.lang3.StringUtils;
import com.example.demo.entities.Domain;
import com.example.demo.entities.Link;

public class UrlParser {
	public UrlParser() {
	}

	public static List<Link> extractLinks(String url) throws IOException {

		final ArrayList<Link> result = new ArrayList<>();
		Domain domain = new Domain();
		domain.setName(url);

		Document doc = Jsoup.connect(url).get();

		Elements links = doc.select("a[href]");
		Elements media = doc.select("[src]");
		Elements imports = doc.select("link[href]");

		for (Element link : links) {
			Link externLink = new Link();

			String currentUrl = link.attr("abs:href");
			String subStringUrl = StringUtils.substringBetween(currentUrl, ".", ".");

			externLink.setUrl(url);
			externLink.setDomain(domain);
			if (currentUrl.contains(subStringUrl)) {
				externLink.setType("intern");
			} else {
				externLink.setType("extern");
			}

			result.add(externLink);
		}

		for (Element src : media) {
			Link externLink = new Link();
			String currentUrl = src.attr("abs:src");
			String subStringUrl = StringUtils.substringBetween(currentUrl, ".", ".");
			externLink.setUrl(url);
			externLink.setDomain(domain);
			if (currentUrl.contains(subStringUrl)) {
				externLink.setType("intern");
			} else {
				externLink.setType("extern");
			}
			result.add(externLink);
		}

		for (Element link : imports) {
			Link externLink = new Link();
			String currentUrl = link.attr("abs:href");
			String subStringUrl = StringUtils.substringBetween(currentUrl, "", ".");
			externLink.setUrl(url);
			externLink.setDomain(domain);
			if (currentUrl.contains(subStringUrl)) {
				externLink.setType("intern");
			} else {
				externLink.setType("extern");
			}
			result.add(externLink);
		}
		return result;
	}
	

}
