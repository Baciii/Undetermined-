package com.wzk.dao;

import lombok.Data;

/**
 * @author wzk
 * @date 2022/5/14 21:24
 */
@Data
public class ArticleBody {
    private Long id;
    private String content;
    private String contentHtml;
    private Long articleId;
}
