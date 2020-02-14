package com.xjliang.bootlaunch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder(value = {"content", "title"})
public class ArticleVO {

    //@JsonIgnore
    private Long id;

    //@JsonProperty("auther")
    private String author;

    private String title;

    @NotEmpty(message = "文章内容不能为空，请检查您的输入")
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private List<Reader> reader;
}
