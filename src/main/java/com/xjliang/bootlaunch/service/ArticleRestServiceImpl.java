package com.xjliang.bootlaunch.service;

import com.xjliang.bootlaunch.dao.ArticleJDBCDAO;
import com.xjliang.bootlaunch.model.Article;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestServiceImpl implements ArticleRestService {

    @Autowired
    private ArticleJDBCDAO articleJDBCDAO;

    @Override
    public Article saveArticle(Article article) {
        articleJDBCDAO.save(article);
        return article;
    }

    @Override
    public Article findArticleById(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> findAllArticles() {
        return articleJDBCDAO.findAll();
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleJDBCDAO.deleteById(id);
    }
}
