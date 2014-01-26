package com.my.rss;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Item;

public class RssView extends AbstractRssFeedView {

	private String title;
	private String description;
	private String link;
		
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
			HttpServletRequest request) {
			
		feed.setTitle(this.getTitle());
		feed.setDescription(this.getDescription());
		feed.setLink(this.getLink());
			
		super.buildFeedMetadata(model, feed, request);
	}
		
		
	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		@SuppressWarnings("unchecked")
		List<Item> items = (List<Item>) model.get("rssContent");
			
		return items;
	}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getLink() {
			return link;
		}


		public void setLink(String link) {
			this.link = link;
		}

		
		

}
