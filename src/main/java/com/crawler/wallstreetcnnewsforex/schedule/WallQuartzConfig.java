package com.crawler.wallstreetcnnewsforex.schedule;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


@Configuration
public class WallQuartzConfig {

    @Autowired
    private WallJobFactory myJobFactory;


    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(myJobFactory);
        System.out.println("myJobFactory:" + myJobFactory);
        return schedulerFactoryBean;
    }


    @Bean
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }


}