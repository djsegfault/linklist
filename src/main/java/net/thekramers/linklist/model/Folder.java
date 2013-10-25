package net.thekramers.linklist.model;

import java.util.ArrayList;
import java.util.List;

public class Folder {

	private final long id;
	private String name;
	public List<Link> links;
	
	public Folder(Long id, String name) {
		this.id = id;
		this.name = name;
		 links = new ArrayList<Link>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(Link link) {
		this.links.add(link);
	}

}
