package com.crawler.wallstreetcnnewsforex.domain;

import java.util.Date;

public class ManagerInfo {
    private Integer id;

    private String name;

    private Date nextStartTime;

    private Integer sleep;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNextStartTime() {
        return nextStartTime;
    }

    public void setNextStartTime(Date nextStartTime) {
        this.nextStartTime = nextStartTime;
    }

    public Integer getSleep() {
        return sleep;
    }

    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }
}