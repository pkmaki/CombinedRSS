package com.my.rss;

	import java.util.List;

	import org.springframework.integration.Message;
	import org.springframework.integration.core.PollableChannel;

	import com.sun.syndication.feed.rss.Item;
	import com.sun.syndication.feed.rss.Content;
	import com.sun.syndication.feed.synd.SyndEntry;


	public class RssSource {
		

		PollableChannel feedChannel;
		

		public void receiveFeed(List<Item> items){

			Item item = null;
			Content content =null;
			
			if (this.feedChannel != null ) {
				
				@SuppressWarnings("unchecked")
				Message<SyndEntry> message =  (Message<SyndEntry>) this.feedChannel.receive(1000);
				int count = 0;
		
				while (message != null){
					
					SyndEntry entry = message.getPayload();
					
					if (entry != null) {			

							item = new Item();
							content = new Content();
							content.setValue(entry.getDescription().getValue());
							item.setContent(content);
							item.setTitle(entry.getTitle());
							item.setLink(entry.getLink());
							item.setPubDate(entry.getPublishedDate());
							
							items.add(item);
							
						}
					
						message = (Message<SyndEntry>) this.feedChannel.receive(1000);				
					
				}
			}
		}


		public PollableChannel getFeedChannel() {
			return feedChannel;
		}
		public void setFeedChannel(PollableChannel feedChannel) {
			this.feedChannel = feedChannel;
		}
}
