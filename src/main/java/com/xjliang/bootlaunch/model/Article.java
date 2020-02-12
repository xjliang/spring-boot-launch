package com.xjliang.bootlaunch.model;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;
}
