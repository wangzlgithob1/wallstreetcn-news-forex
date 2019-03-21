package com.crawler.wallstreetcnnewsforex.spider;

import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;
import com.crawler.wallstreetcnnewsforex.service.ArticleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Date;

@Slf4j
@Component
public class WallstreetcnPipeline implements Pipeline {

	@Autowired
	ArticleInfoService articleInfoService;

	@Override
	public void process(ResultItems resultItems, Task task) {
		ArticleInfo article0 = resultItems.get(ArticleInfo.class.getSimpleName());

		log.info("{}+++++++++++",article0);

		ArticleInfo article = new ArticleInfo();
		article.setArticleId(12121212);
		article.setTitle("test");
		article.setSummary("test");
		article.setLabel("test");
		article.setSource("test");
		article.setTime(new Date());
		article.setContent("test");
		article.setImage("test");
		article.setInputTime(new Date());
		article.setUpdateTime(new Date());

		if (article != null) {
			articleInfoService.insert(article);
		}
	}

}
