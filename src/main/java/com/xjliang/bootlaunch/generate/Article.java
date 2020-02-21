package com.xjliang.bootlaunch.generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * article
 * @author 
 */
@Data
public class Article implements Serializable {
    private Long id;

    private String author;

    private String title;

    private String content;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}