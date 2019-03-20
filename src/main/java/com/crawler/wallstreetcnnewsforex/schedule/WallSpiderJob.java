package com.crawler.wallstreetcnnewsforex.schedule;

import com.crawler.wallstreetcnnewsforex.service.ManagerInfoService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WallSpiderJob implements Job {
	
	@Autowired
	ManagerInfoService managerInfoService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		// TODO Auto-generated method stub
		String jobName = context.getJobDetail().getKey().toString().substring(8);
		System.out.println(jobName+"问题结算定时任务开启..");
		
		//更新job的执行状态
		System.out.println(managerInfoService.selectAll().toString());
		
        System.out.println(jobName+"问题结算定时任务结束..");
	}
 
}