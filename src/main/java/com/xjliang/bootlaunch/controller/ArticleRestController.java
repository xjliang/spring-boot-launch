package com.xjliang.bootlaunch.controller;

import com.xjliang.bootlaunch.model.AjaxResponse;
import com.xjliang.bootlaunch.model.Article;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // @Controller + @ResponseBody
@RequestMapping("/rest")
public class ArticleRestController {

    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article", httpMethod = "POST")
    @ApiResponses({
        @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
        @ApiResponse(code = 400, message = "用户输入错误", response = AjaxResponse.class),
        @ApiResponse(code = 500, message = "系统内部错误", response = AjaxResponse.class)
    })
    //    @RequestMapping(value = "/articles", method = POST, produces = "application/json")
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("saveArticle: {}", article);

        return AjaxResponse.success(article);
    }

    //    @RequestMapping(value = "/articles/{id}", method = GET, produces = "application/json")
    @GetMapping("/articles/{id}")
    public AjaxResponse findArticle(@PathVariable Long id) {
        Article article = Article.builder()
            .id(id)
            .author("xjliang")
            .content("spring boot 2.x 深入浅出")
            .title("t1").build();
        return AjaxResponse.success(article);
    }

    //    @RequestMapping(value = "/articles/{id}", method = PUT, produces = "application/json")
    @PutMapping("/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);

        log.info("updateArticle: {}", article);

        return AjaxResponse.success(article);
    }

    //    @RequestMapping(value = "/articles/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {

        log.info("deleteArticle: {}", id);

        return AjaxResponse.success(id);
    }
}
