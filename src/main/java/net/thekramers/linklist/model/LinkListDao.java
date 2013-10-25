package net.thekramers.linklist.model;

import java.util.List;

public interface LinkListDao {
	
	public Link getLink(Long id);
	
	public List<Link> getLinks();

	public Folder getFolder(Long id);
	
	public Folder getFolder(String name);
	
	public List<Folder>  getFolders();

}
