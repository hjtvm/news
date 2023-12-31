package com.ssm.service;

import com.ssm.po.News;
import com.ssm.utils.PageBean;


/**
 * @author lenovo
 */
public interface NewsService {
    PageBean<News> findNewsByPage(String keywords, Integer newsListCategoryId, Integer currentPage,  Integer pageSize);
    News getNewsByNewsId(Integer newsId);
    int setNewsPublishStatus(News news);
    int addNews(News news);
    int editNews(News news);
    int delNews(Integer newsId);
}
