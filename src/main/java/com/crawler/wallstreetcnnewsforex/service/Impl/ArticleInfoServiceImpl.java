package com.crawler.wallstreetcnnewsforex.service.Impl;

import com.crawler.wallstreetcnnewsforex.dao.ArticleInfoMapper;
import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;
import com.crawler.wallstreetcnnewsforex.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Autowired
    ArticleInfoMapper articleInfoMapper;

    @Override
    public List<ArticleInfo> selectAll() {
        return articleInfoMapper.selectAll();
    }


}
