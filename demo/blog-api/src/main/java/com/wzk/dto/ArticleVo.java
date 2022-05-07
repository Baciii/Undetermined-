package com.wzk.dto;

import lombok.Data;

import java.util.List;


@Data
public class ArticleVo {

    private String id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Integer weight;
    /**
     * 创建时间
     */
    private String createDate;

    private String author;

    private List<TagVo> tags;

//    private ArticleBodyVo body;



//    private CategoryVo category;

}
