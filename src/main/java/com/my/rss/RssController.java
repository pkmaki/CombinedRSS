package com.my.rss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.syndication.feed.rss.Item;

@Controller
public class RssController {
	
	@Autowired
	private RssSource rssSource1;
	
	@Autowired
	private RssSource rssSource2;
	
	@Autowired
	private RssSource rssSource3;
	
	@Autowired
	private RssSource rssSource4;
	
	List<Item> items = new ArrayList<Item>();


	@RequestMapping(value="/rssfeed", method = RequestMethod.GET)
	public ModelAndView getFeedInRss() {
		
		rssSource1.receiveFeed(items); 
		rssSource2.receiveFeed(items); 
		rssSource3.receiveFeed(items); 	
		rssSource4.receiveFeed(items); 
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rssView");
		mav.addObject("rssContent", items);
		
		return mav;

	}

}
