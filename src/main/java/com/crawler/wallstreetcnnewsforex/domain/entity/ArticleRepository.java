package com.crawler.wallstreetcnnewsforex.domain.entity;

import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleInfo, Integer> {
	
	@Query(value="select * from t_article order by time desc limit :startIndex, :displayLength" , nativeQuery = true)
    List<ArticleInfo> queryArticleSortByTime(
            @Param("startIndex") int startIndex,
            @Param("displayLength") int displayLength);
	
}
