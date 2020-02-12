package com.xjliang.bootlaunch.service;

import com.xjliang.bootlaunch.dao.ArticleJDBCDAO;
import com.xjliang.bootlaunch.model.Article;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestServiceImpl implements ArticleRestService {

    @Autowired
    private ArticleJDBCDAO articleJDBCDAO;

    @Autowired
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;


    @Override
    public Article saveArticle(Article article) {
        articleJDBCDAO.save(article, primaryJdbcTemplate);
        articleJDBCDAO.save(article, secondaryJdbcTemplate);
        return article;
    }

    @Override
    public Article findArticleById(Long id) {
        return articleJDBCDAO.findById(id, primaryJdbcTemplate);
    }

    @Override
    public List<Article> findAllArticles() {
        return articleJDBCDAO.findAll(primaryJdbcTemplate);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article, primaryJdbcTemplate);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleJDBCDAO.deleteById(id, primaryJdbcTemplate);
    }
}
