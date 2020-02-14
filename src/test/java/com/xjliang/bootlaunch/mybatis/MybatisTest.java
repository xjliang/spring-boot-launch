package com.xjliang.bootlaunch.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjliang.bootlaunch.generator.testdb.Article;
import com.xjliang.bootlaunch.generator.testdb.ArticleDAO;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Resource
    private ArticleDAO articleDAO;

    @Test
    public void testPageHelper() {
        // 只有 PageHelper.startPage 方法后的第一个 mybatis 查询方法(select) 会被分页
        PageHelper.startPage(2, 2);

        List<Article> articleList = articleDAO.selectByExample(null);
        PageInfo<Article> page = PageInfo.of(articleList);
        System.out.println(page);
    }
}
