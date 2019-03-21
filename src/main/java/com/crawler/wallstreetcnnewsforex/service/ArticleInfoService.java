package com.crawler.wallstreetcnnewsforex.service;


import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;

import java.util.List;

public interface ArticleInfoService {

    List<ArticleInfo> selectAll();

    int insert(ArticleInfo record);


}
