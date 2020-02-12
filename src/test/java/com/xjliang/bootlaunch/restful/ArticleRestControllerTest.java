package com.xjliang.bootlaunch.restful;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.xjliang.bootlaunch.controller.ArticleRestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Slf4j
@SpringBootTest
public class ArticleRestControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
    }

//    @Test
//    public void saveArticle() throws Exception {
//        String article = "{\n" +
//            "    \"id\": 1,\n" +
//            "    \"author\": \"xjliang\",\n" +
//            "    \"title\": \"spring boot study\",\n" +
//            "    \"content\": \"c\",\n" +
//            "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
//            "    \"reader\":[{\"name\":\"xjliang\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
//            "}";
//
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/articles")
//            .contentType("application/json").content(article))
//            .andExpect(MockMvcResultMatchers.status().isOk())
//            .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("xjliang"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
//            .andDo(print())
//            .andReturn();
//
//        log.info(result.getResponse().getContentAsString());
//    }
}
