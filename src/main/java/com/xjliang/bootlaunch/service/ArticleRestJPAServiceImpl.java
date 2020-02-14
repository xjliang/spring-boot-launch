package com.xjliang.bootlaunch.service;

import com.xjliang.bootlaunch.jpa.testdb.Article;
import com.xjliang.bootlaunch.jpa.testdb.ArticleRepository;
import com.xjliang.bootlaunch.jpa.testdb2.Message;
import com.xjliang.bootlaunch.jpa.testdb2.MessageRepository;
import com.xjliang.bootlaunch.model.ArticleVO;
import com.xjliang.bootlaunch.utils.DozerUtils;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestJPAServiceImpl implements ArticleRestService {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private Mapper dozerMapper;

    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleRepository.save(articlePO);

        Message message = new Message();
        message.setName("hello");
        message.setContent("hello world");
        messageRepository.save(message);

        return article;
    }

    @Override
    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleRepository.save(articlePO);
    }

    @Override
    public ArticleVO findArticleById(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        ArticleVO articleVO = dozerMapper.map(article.get(), ArticleVO.class);
        // articleVO.setReader();
        return articleVO;
    }

    @Override
    public List<ArticleVO> findAllArticles() {
        List<Article> articleLis = articleRepository.findAll();

        return DozerUtils.mapList(articleLis, ArticleVO.class);
    }
}
