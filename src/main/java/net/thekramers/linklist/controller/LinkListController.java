package net.thekramers.linklist.controller;

import java.util.concurrent.atomic.AtomicLong;

import net.thekramers.linklist.model.Link;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LinkListController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/linklist", method=RequestMethod.POST)
    public @ResponseBody Link link(
		@RequestParam(value="folder", required=false, defaultValue="ROOT") String folder ,
		@RequestParam(value="url", required=true) String url,
		@RequestParam(value="description", required=false, defaultValue="") String description) {
	return new Link(counter.incrementAndGet(),folder, url, description);
    }
}