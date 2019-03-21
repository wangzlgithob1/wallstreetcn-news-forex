package com.crawler.wallstreetcnnewsforex.spider;

import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;
import com.crawler.wallstreetcnnewsforex.service.ArticleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Slf4j
@Component
public class WallstreetcnPipeline implements Pipeline {

	@Autowired
	ArticleInfoService articleInfoService;

	@Override
	public void process(ResultItems resultItems, Task task) {

		ArticleInfo article = resultItems.get(ArticleInfo.class.getSimpleName());

		if (article != null) {
			articleInfoService.insert(article);
		}

	}

}
