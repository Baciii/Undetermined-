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

    //标签
    private List<TagVo> tags;

    //文章
    private ArticleBodyVo body;

    //
    private ArticleCategoryVo category;

}
