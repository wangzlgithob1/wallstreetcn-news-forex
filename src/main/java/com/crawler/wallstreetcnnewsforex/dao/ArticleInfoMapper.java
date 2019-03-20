package com.crawler.wallstreetcnnewsforex.dao;

import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;

import java.util.List;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);

    List<ArticleInfo> selectAll();


}