package com.xjliang.bootlaunch.dao;

import com.xjliang.bootlaunch.model.Article;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleJDBCDAO {

    @Autowired
    private JdbcTemplate primaryJdbcTemplate;

    public void save(Article article, JdbcTemplate jdbcTemplate) {
        // jdbcTemplate.update 适合于 insert 、update 和 delete 操作；
        jdbcTemplate
            .update("INSERT INTO article(author, title,content,create_time) values(?, ?, ?, ?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());

    }

    public void deleteById(Long id, JdbcTemplate jdbcTemplate) {
        // jdbcTemplate.update 适合于 insert 、update 和 delete 操作；
        jdbcTemplate.update("DELETE FROM article WHERE id = ?", new Object[]{id});

    }

    public void updateById(Article article, JdbcTemplate jdbcTemplate) {
        // jdbcTemplate.update 适合于 insert 、update 和 delete 操作；
        jdbcTemplate.update(
            "UPDATE article SET author = ?, title = ? ,content = ?,create_time = ? WHERE id = ?",
            article.getAuthor(),
            article.getTitle(),
            article.getContent(),
            article.getCreateTime(),
            article.getId());

    }

    public Article findById(Long id, JdbcTemplate jdbcTemplate) {
        //queryForObject 用于查询单条记录返回结果
        return (Article) jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",
            new Object[]{id}, new BeanPropertyRowMapper(Article.class));
    }

    public List<Article> findAll(JdbcTemplate jdbcTemplate) {
        //query 用于查询结果列表
        return (List<Article>) jdbcTemplate
            .query("SELECT * FROM article ", new BeanPropertyRowMapper(Article.class));
    }
}
