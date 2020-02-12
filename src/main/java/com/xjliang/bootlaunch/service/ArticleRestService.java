package com.xjliang.bootlaunch.service;

import com.xjliang.bootlaunch.model.ArticleVO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

public interface ArticleRestService {

    ArticleVO saveArticle(ArticleVO article);

    void deleteArticleById(Long id);

    void updateArticle(ArticleVO article);

    ArticleVO findArticleById(Long id);

    List<ArticleVO> findAllArticles();
}
