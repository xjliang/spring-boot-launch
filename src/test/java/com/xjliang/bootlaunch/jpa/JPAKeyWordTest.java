package com.xjliang.bootlaunch.jpa;

import com.xjliang.bootlaunch.jpa.testdb.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void userTest() {
        System.out.println(articleRepository.findByAuthor("xjliang"));
        System.out.println(articleRepository.findByAuthor("beta"));
    }
}
