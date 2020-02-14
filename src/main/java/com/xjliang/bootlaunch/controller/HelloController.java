package com.xjliang.bootlaunch.controller;

import com.xjliang.bootlaunch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

//    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public ArticleVO hello() {

        ArticleVO article = ArticleVO.builder().id(3L).author("无情").build();
        log.info("test: " + article);
        return article;
    }
}
