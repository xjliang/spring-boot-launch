package com.xjliang.bootlaunch.controller;

import com.xjliang.bootlaunch.config.exception.AjaxResponse;
import com.xjliang.bootlaunch.model.ArticleVO;
import com.xjliang.bootlaunch.service.ExceptionService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Resource
    private ExceptionService exceptionService;

//    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public ArticleVO hello() {

        ArticleVO article = ArticleVO.builder().id(3L).author("无情").build();
        log.info("test: " + article);
        return article;
    }

    @RequestMapping("/ex/system")
    public @ResponseBody
    AjaxResponse system() {

        exceptionService.systemBizError();

        return AjaxResponse.success();
    }


    @RequestMapping("/ex/user")
    public @ResponseBody  AjaxResponse user(Integer input) {

        return AjaxResponse.success(exceptionService.userBizError(input));
    }
}
