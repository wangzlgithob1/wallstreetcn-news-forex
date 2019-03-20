package com.crawler.wallstreetcnnewsforex.spider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import java.util.Date;

@Component
public class CrawlerLauncher {
	
	@Autowired
	WallstreetcnPipeline wallstreetcnPipeline;
	
	public void launcher(Date date) {
		String url = "https://api.wallstreetcn.com/apiv1/content/fabricate-articles?channel=forex&accept=article&limit=20";
		Spider.create(new WallstreetcnPageProcessor())
				.addPipeline(wallstreetcnPipeline)
				.addUrl(url)
				.thread(1)
				.run();
	}

}
