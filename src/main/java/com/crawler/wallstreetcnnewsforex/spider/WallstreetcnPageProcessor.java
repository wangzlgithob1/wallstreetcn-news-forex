package com.crawler.wallstreetcnnewsforex.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WallstreetcnPageProcessor implements PageProcessor {
	
	public Date flag;

	public WallstreetcnPageProcessor(Date flag){
		this.flag=flag;
	}
	
	@Override
	public void process(Page page) {

		if (page.getUrl().regex("apiv1/content/fabricate-articles").match()) {
			String raw = page.getRawText();
			JSONObject json = JSONObject.parseObject(raw);
			JSONObject data = json.getJSONObject("data");
			String nextCursor = data.getString("next_cursor");
			JSONArray items = data.getJSONArray("items");
			List<String> targetUrls = new ArrayList<>();
			for (Object item : items) {
				JSONObject resource = ((JSONObject) item).getJSONObject("resource");
				String articleId = resource.getString("id");
				String time = resource.getString("display_time");
				Date date = new Date(Long.parseLong(time) * 1000L);
				if (date.after(flag)) {
					String articleUrl = String.format("https://api-prod.wallstreetcn.com/apiv1/content/articles/%s?extract=0", articleId);
					targetUrls.add(articleUrl);
				}
			}
			page.addTargetRequests(targetUrls);
			//如果没有20个说明已经不用翻页了
			if (targetUrls.size() == 20) {
				String nextUrl = String.format("https://api.wallstreetcn.com/apiv1/content/fabricate-articles?channel=forex&accept=article&cursor=%s&limit=20", nextCursor);
				page.addTargetRequest(nextUrl);
			}
		} else if (page.getUrl().regex("https://api-prod.wallstreetcn.com/apiv1/content/articles/\\d+\\?extract=0").match()) {
			Json json = page.getJson();
			System.out.println("===============222"+json.toString());
			String articleId = json.jsonPath("$.data.id").get();
			String title = json.jsonPath("$.data.title").get();
			String summary = json.jsonPath("$.data.content_short").get();
			String label = json.jsonPath("$.data.themes[0].name").get();
			String sourceName = json.jsonPath("$.data.source_name").get();
			String displayName = json.jsonPath("$.data.author.display_name").get();
			String source = StringUtils.isEmpty(sourceName) ? displayName : sourceName;
			String time = json.jsonPath("$.data.display_time").get();
			String content = json.jsonPath("$.data.content").get();
			String image = json.jsonPath("$.data.image_uri").get();

			content = Jsoup.clean(content, new Whitelist().addTags("img").addAttributes("img", "data-original", "align", "alt", "height", "src", "title", "width")
	                .addProtocols("img", "src", "http", "https"));


			System.out.println(title);
			ArticleInfo article = new ArticleInfo();
			article.setArticleId(Integer.parseInt(articleId));
			article.setTitle(title);
			article.setSummary(summary);
			article.setLabel(label);
			article.setSource(source);
			article.setTime(new Date(Long.parseLong(time) * 1000L));
			article.setContent(content);
			article.setImage(image);
			article.setInputTime(new Date());
			article.setUpdateTime(new Date());
			
			page.putField(ArticleInfo.class.getSimpleName(), article);
		}
	}

	@Override
	public Site getSite() {
		Site site = Site.me()
				.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36")
				.setSleepTime(1000);
		return site;
	}
	
}
