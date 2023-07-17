package com.ssm.web.controller;

import com.ssm.po.Category;
import com.ssm.po.News;
import com.ssm.service.CategoryService;
import com.ssm.service.NewsService;
import com.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author lenovo
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/findNewsByPage.action")
    public String findNewsByPage(String keywords, Integer newsListCategoryId, @RequestParam(defaultValue = "1")Integer currentPage,
                                 @RequestParam(defaultValue = "10")Integer pageSize, Model model){
        List<Category> categoryList = categoryService.findCategoryList();
        model.addAttribute("categoryList",categoryList);
        PageBean<News> pb = newsService.findNewsByPage(keywords,newsListCategoryId,currentPage,pageSize);
        model.addAttribute("pb",pb);
        model.addAttribute("keywords",keywords);
        model.addAttribute("newsListCategoryId",newsListCategoryId);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("pageSize",pageSize);
        return "news/news_list";
    }

    @RequestMapping(value = "/setNewsPublishStatus.action")
    @ResponseBody
    public News setNewsPublishStatus(@RequestBody News news,Model model){
        int rows = newsService.setNewsPublishStatus(news);
        if (rows>0){
            return news;
        }else {
            news.setNewsId(0);
            return news;
        }
    }

    @RequestMapping(value = "/toAddNews.action")
    public String toAddNews(Model model){
        List<Category> categoryList = categoryService.findCategoryList();
        model.addAttribute("categoryList",categoryList);
        return "news/add_news";
    }

    @RequestMapping(value = "/addNews.action", method = RequestMethod.POST)
    public String addNews(News news,Model model){
        Date date = new Date();
        news.setPublishTime(date);
        news.setPublishStatus("1");
        int rows = newsService.addNews(news);
        if (rows>0){
            return "redirect:findNewsByPage.action";
        }else {
            List<Category> categoryList = categoryService.findCategoryList();
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("news",news);
            return "news/add_news";
        }
    }

    @RequestMapping(value = "/editNews.action",method = RequestMethod.POST)
    public String editNews(News news,Model model){
        Date date = new Date();
        news.setPublishTime(date);
        news.setPublishStatus("1");
        int rows = newsService.addNews(news);
        if (rows>0){
            return "redirect:findNewsByPage.action";
        }else {
            List<Category> categoryList = categoryService.findCategoryList();
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("news",news);
            return "news/edit_news";
        }
    }

    @RequestMapping(value = "/toEditNews.action")
    public String toEditNews(Integer newsId,Model model){
        News news = newsService.getNewsByNewsId(newsId);
        if (news!=null){
            model.addAttribute("news",news);
            List<Category> categoryList = categoryService.findCategoryList();
            model.addAttribute("categoryList", categoryList);
        }
        return "news/edit_news";
    }

    @RequestMapping(value = "/delNews.action")
    @ResponseBody
    public News delNews(@RequestBody News news,Model model){
        int rows = newsService.delNews(news.getNewsId());
        if (rows>0){
            return news;
        }else {
            news.setNewsId(0);
            return news;
        }
    }

    @RequestMapping(value = "/index.action")
    public String index(HttpServletRequest request, HttpServletResponse response,String keywords, Integer newsListCategoryId,
                        @RequestParam(defaultValue = "1")Integer currentPage, @RequestParam(defaultValue = "10")Integer pageSize, Model model){
        PageBean<News> pb1 = newsService.findNewsByPage(keywords,1,currentPage,pageSize);
        model.addAttribute("pb1",pb1);
        PageBean<News> pb2 = newsService.findNewsByPage(keywords,2,currentPage,pageSize);
        model.addAttribute("pb2",pb2);
        return "../first";
    }

    @RequestMapping(value = "/findNewsByCategoryIdPage.action")
    public String findNewsByCategoryIdPage(HttpServletRequest request, HttpServletResponse response,String keywords, Integer newsListCategoryId,
                                           @RequestParam(defaultValue = "1")Integer currentPage, @RequestParam(defaultValue = "10")Integer pageSize, Model model){
        Category category = categoryService.findCategoryById(newsListCategoryId);
        model.addAttribute("category",category);
        PageBean<News> pb = newsService.findNewsByPage(keywords,newsListCategoryId,currentPage,pageSize);
        model.addAttribute("pb",pb);
        model.addAttribute("newsListCategoryId",newsListCategoryId);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("pageSize",pageSize);
        return "../list";
    }

    @RequestMapping(value = "/findFrontNewsByNewsId.action")
    public String findFrontNewsByNewsId(Integer newsId,Model model){
        News news = newsService.getNewsByNewsId(newsId);
        if (news!=null){
            model.addAttribute("news",news);
        }
        return "../detail";
    }
}
