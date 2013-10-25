package net.thekramers.linklist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class LinkListDaoArrayImpl implements LinkListDao {
	
	private Map<Long,Link> links;
	private Map<Long,Folder> folders;
    private final AtomicLong counter = new AtomicLong();

	public LinkListDaoArrayImpl() {
		Link newLink;
		Folder newFolder;
		
		links = new ConcurrentHashMap<Long,Link>();
		folders = new ConcurrentHashMap<Long,Folder>();
		
		newFolder = new Folder(counter.incrementAndGet(), "User Groups");
		folders.put(newFolder.getId(), newFolder);
		newLink = new Link(counter.incrementAndGet(), "http://www.blu.org", "Boston Linux and UNIX Group");
		newFolder.addLink(newLink);
		links.put(newLink.getId(), newLink);

		newLink = new Link(counter.incrementAndGet(), "http://www.agilenewengland.org", "Agile New England");
		newFolder.addLink(newLink);
		links.put(newLink.getId(), newLink);
		
		System.out.println("Folder " + newFolder.getName() + " has " + newFolder.getLinks().size() + " links.");
		
		newFolder = new Folder(counter.incrementAndGet(), "Shopping");
		folders.put(newFolder.getId(), newFolder);
		newLink = new Link(counter.incrementAndGet(), "http://www.woot.com", "Woot Dot Com");
		newFolder.addLink(newLink);
		links.put(newLink.getId(), newLink);

		newLink = new Link(counter.incrementAndGet(), "http://www.thinkgeek.com", "Think Geek");
		newFolder.addLink(newLink);
		links.put(newLink.getId(), newLink);

		System.out.println("Folder " + newFolder.getName() + " has " + newFolder.getLinks().size() + " links.");
		
		System.out.println("There are " + links.size() + " links.");
		
	}
	
	public Link getLink(Long id) {
		return links.get(id);
	}
	
	public List<Link> getLinks() {
		ArrayList<Link> linkList = new ArrayList<Link>(links.values());
		System.out.println("getLinks returning  " + linkList.size() + " links");
		return linkList;
	}

	public Folder getFolder(Long id) {
		return folders.get(id);
	}
	
	public Folder getFolder(String name) {
		Folder target = null;
		for(Folder folder : folders.values()) {
			if(folder.getName().equals(name)) {
				target = folder;
				break;
			}
		}
		
		return target;
	}
	
	public List<Folder> getFolders() {
		return new ArrayList<Folder>(folders.values());
	}


}
