package com.crawler.wallstreetcnnewsforex.service;


import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;

import java.util.List;

public interface ArticleInfoService {

    List<ArticleInfo> selectAll(int pageNum,int pageSize);

    int insert(ArticleInfo record);


}
