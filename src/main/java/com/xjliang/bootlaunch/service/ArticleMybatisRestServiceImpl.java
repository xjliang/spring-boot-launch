package com.xjliang.bootlaunch.service;

import com.xjliang.bootlaunch.generate.Article;
import com.xjliang.bootlaunch.generate.ArticleDAO;
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
    private Mapper dozerMapper;

    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleDAO.insert(articlePO);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleDAO.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleDAO.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        Article articlePO = articleDAO.selectByPrimaryKey(id);
        return dozerMapper.map(articlePO, ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleDAO.selectByExample(null);
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
