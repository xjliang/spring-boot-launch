package com.xjliang.bootlaunch.controller;

import com.xjliang.bootlaunch.model.AjaxResponse;
import com.xjliang.bootlaunch.model.ArticleVO;
import com.xjliang.bootlaunch.service.ArticleRestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // @Controller + @ResponseBody
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource(name = "articleRestJPAServiceImpl")
    private ArticleRestService articleRestService;

    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "ArticleVO", httpMethod = "POST")
    @ApiResponses({
        @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
        @ApiResponse(code = 400, message = "用户输入错误", response = AjaxResponse.class),
        @ApiResponse(code = 500, message = "系统内部错误", response = AjaxResponse.class)
    })
    //    @RequestMapping(value = "/articles", method = POST, produces = "application/json")
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article) {
        log.info("saveArticle: {}", articleRestService.saveArticle(article));

        return AjaxResponse.success(article);
    }

    //    @RequestMapping(value = "/articles/{id}", method = GET, produces = "application/json")
    @GetMapping("/articles/{id}")
    public AjaxResponse findArticle(@PathVariable Long id) {
        ArticleVO article = articleRestService.findArticleById(id);
        return AjaxResponse.success(article);
    }

    @GetMapping("/articles")
    public AjaxResponse findAllArticles() {
        return AjaxResponse.success(articleRestService.findAllArticles());
    }

    //    @RequestMapping(value = "/articles/{id}", method = PUT, produces = "application/json")
    @PutMapping("/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO article) {
        article.setId(id);

        articleRestService.updateArticle(article);

        return AjaxResponse.success(article);
    }

    //    @RequestMapping(value = "/articles/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {

        articleRestService.deleteArticleById(id);

        return AjaxResponse.success(id);
    }
}
