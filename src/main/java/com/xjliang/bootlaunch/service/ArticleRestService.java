package com.xjliang.bootlaunch.service;

import com.xjliang.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestService {

    public String save(Article article) {

        log.info("saveArticle: {}", article);

        return "test";
    }
}
