package com.wzk.service;


import com.wzk.dto.Result;
import com.wzk.dto.params.CommentParam;

/**
 * @author wzk
 * @date 2022/5/14 23:30
 */
public interface CommentService {
    Result commentsByArticleId(Long articleId);

    Result createComment(CommentParam commentParam);
}
