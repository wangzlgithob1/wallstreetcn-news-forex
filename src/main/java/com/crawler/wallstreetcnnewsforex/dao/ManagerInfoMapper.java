package com.crawler.wallstreetcnnewsforex.dao;

import com.crawler.wallstreetcnnewsforex.domain.ManagerInfo;

import java.util.List;

public interface ManagerInfoMapper {

    int insert(ManagerInfo record);

    int insertSelective(ManagerInfo record);

    List<ManagerInfo> selectAll();


}