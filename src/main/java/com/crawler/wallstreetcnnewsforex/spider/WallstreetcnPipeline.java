package com.crawler.wallstreetcnnewsforex.spider;

import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;
import com.crawler.wallstreetcnnewsforex.domain.entity.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class WallstreetcnPipeline implements Pipeline {

	@Autowired
	ArticleRepository articleRepository;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		ArticleInfo article = resultItems.get(ArticleInfo.class.getSimpleName());
		if (article != null) {
			articleRepository.save(article);
		}
	}

}
