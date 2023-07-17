package com.ssm.dao;

import com.ssm.po.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lenovo
 */
public interface NewsDao {
    int getNewsCount(@Param("keywords") String keywords,@Param("newsListCategoryId") Integer newsListCategoryId);
    List<News> findNewsList(@Param("keywords") String keywords,@Param("newsListCategoryId") Integer newsListCategoryId,@Param("startRows") Integer startRows,
                            @Param("pageSize") Integer pageSize);
    News getNewsByNewsId(Integer newsId);
    int addNews(News news);
    int updateNews(News news);
    int setNewsPublishStatus(News news);
    int delNews(Integer newsId);
}
