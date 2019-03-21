package com.crawler.wallstreetcnnewsforex.schedule;

import com.crawler.wallstreetcnnewsforex.spider.WallstreetcnPageProcessor;
import com.crawler.wallstreetcnnewsforex.spider.WallstreetcnPipeline;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.Calendar;
import java.util.Date;


@Component
public class WallSpiderJob implements Job {

	@Autowired
	WallstreetcnPipeline wallstreetcnPipeline;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		// TODO Auto-generated method stub
		String jobName = context.getJobDetail().getKey().toString().substring(8);

		System.out.println(jobName+"问题结算定时任务开启..");

		//昨日时间
		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		Date date=cal.getTime();

		//执行Wall的爬虫
		String url = "https://api.wallstreetcn.com/apiv1/content/fabricate-articles?channel=forex&accept=article&limit=20";
		Spider.create(new WallstreetcnPageProcessor(date))
				.addPipeline(wallstreetcnPipeline)
				.addUrl(url)
				.thread(1)
				.run();
		
        System.out.println(jobName+"问题结算定时任务结束..");



	}


 
}