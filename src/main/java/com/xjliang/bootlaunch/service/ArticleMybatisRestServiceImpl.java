package com.xjliang.bootlaunch.service;

import com.xjliang.bootlaunch.generator.testdb.Article;
import com.xjliang.bootlaunch.generator.testdb.ArticleDAO;
import com.xjliang.bootlaunch.generator.testdb2.Message;
import com.xjliang.bootlaunch.generator.testdb2.MessageDAO;
import com.xjliang.bootlaunch.model.ArticleVO;
import com.xjliang.bootlaunch.utils.DozerUtils;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService {

    @Resource
    private ArticleDAO articleDAO;

    @Resource
    private MessageDAO messageDAO;

    @Resource
    private Mapper dozerMapper;

    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleDAO.insert(articlePO);

//        articleDAO.insertSelective(articlePO);

        Message message = new Message();
        message.setName("kobe");
        message.setContent("well done");
        messageDAO.insert(message);

        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleDAO.deleteByPrimaryKey(id);

//        ArticleExample articleExample = new ArticleExample();
//        articleExample.createCriteria().andIdEqualTo(id);
//        articleExample.createCriteria().andAuthorEqualTo("xjliang");
//        int count = articleDAO.deleteByExample(articleExample);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleDAO.updateByPrimaryKeySelective(articlePO);

//        Article article1 = new Article();
//        article1.setAuthor("beta");
//        ArticleExample articleExample = new ArticleExample();
//        articleExample.createCriteria().andIdEqualTo(article.getId());
//
//        int count = articleDAO.updateByExample(article1, articleExample);
    }

    @Override
    public ArticleVO getArticle(Long id) {

//        ArticleExample articleExample = new ArticleExample();
//        articleExample.createCriteria().andIdEqualTo(id);
//        Article article = articleDAO.selectByExample(articleExample).get(0);

        Article articlePO = articleDAO.selectByPrimaryKey(id);
        return dozerMapper.map(articlePO, ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleDAO.selectByExample(null);
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
