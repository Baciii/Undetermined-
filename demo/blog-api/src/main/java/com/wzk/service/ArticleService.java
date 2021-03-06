package com.wzk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzk.dao.Article;
import com.wzk.dto.params.PageParams;
import com.wzk.dto.Result;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author wzk
 * @date 2022/5/1 21:25
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页查询 文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    /**
     * 最热文章
     * @param limit
     * @return
     */
    Result hotArticle(int limit);

    /**
     * 最新文章
     * @param limit
     * @return
     */
    Result newArticle(int limit);


    /**
     * 文章归档
     * @return
     */
    Result listArchives();

    /**
     * 查询文章内容
     * @param articleId
     * @return
     */
    Result findArticleById(Long articleId);
}
