package com.wzk.controller;

import com.wzk.dto.Result;
import com.wzk.dto.params.CommentParam;
import com.wzk.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wzk
 * @date 2022/5/14 23:29
 */
@RestController
@RequestMapping("comments")
public class CommentController {
    @Resource
    private CommentService commentService;

    /**
     * 查看文章评论
     */
    @GetMapping("article/{id}")
    public Result comments(@PathVariable("id") Long articleId) {
        return commentService.commentsByArticleId(articleId);
    }

    /**
     * 新增文章评论
     */
    @PostMapping("create/change")
    public Result createComment(@RequestBody CommentParam commentParam) {
        return commentService.createComment(commentParam);
    }
}
