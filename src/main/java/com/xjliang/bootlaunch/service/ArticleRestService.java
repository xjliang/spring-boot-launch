package com.xjliang.bootlaunch.service;

import com.xjliang.bootlaunch.model.Article;
import java.util.List;


public interface ArticleRestService {

    Article saveArticle(Article article);

    Article findArticleById(Long id);

    List<Article> findAllArticles();

    void updateArticle(Article article);

    void deleteArticleById(Long id);
}
