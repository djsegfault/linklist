package net.thekramers.linklist.controller;

import java.util.List;

import net.thekramers.linklist.model.Folder;
import net.thekramers.linklist.model.Link;
import net.thekramers.linklist.model.LinkListDao;
import net.thekramers.linklist.model.LinkListDaoArrayImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LinkListController {
	LinkListDao dao;
	
	public LinkListController() {
		/** TODO Inject the right implementation **/
		dao = new LinkListDaoArrayImpl();
	}

    @RequestMapping(value="/linklist/links", method=RequestMethod.GET)
    public @ResponseBody List<Link> link() {
    	return dao.getLinks();
    }

    @RequestMapping(value="/linklist/links/{linkId}", method=RequestMethod.GET)
    public @ResponseBody Link link(@PathVariable Long linkId) {
    	return dao.getLink(linkId);
    }

    @RequestMapping(value="/linklist/folders", method=RequestMethod.GET)
    public @ResponseBody List<Folder> folders() {
    	return dao.getFolders();
    }
    
    
    /**
     * 
		@RequestParam(value="folder", required=false, defaultValue="ROOT") String folder ,
		@RequestParam(value="url", required=true) String url,
		@RequestParam(value="description", required=false, defaultValue="") String description
     */
}