package net.thekramers.linklist.model;

public class Link {
    private final long id;
	private String url;
	private String description;
	private String folder;

	public Link(Long id, String folder, String url, String description) {
		this.id = id;
		this.url = url;
		this.description = description;
		this.folder = folder;
	}

	public long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

}
