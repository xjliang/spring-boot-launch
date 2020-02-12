package com.xjliang.bootlaunch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByAuthor(String author);
}
