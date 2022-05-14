package com.wzk.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wzk.dao.Article;
import com.wzk.dao.Comment;
import com.wzk.dao.SysUser;
import com.wzk.dto.CommentVo;
import com.wzk.dto.Result;
import com.wzk.dto.UserVo;
import com.wzk.dto.params.CommentParam;
import com.wzk.mapper.ArticleMapper;
import com.wzk.mapper.CommentMapper;
import com.wzk.service.CommentService;
import com.wzk.service.SysUserService;
import com.wzk.utils.UserThreadLocal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wzk
 * @date 2022/5/14 23:31
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private SysUserService sysUserService;

    /**
     * 根据文章id查询评论
     * @param articleId
     * @return
     */
    @Override
    public Result commentsByArticleId(Long articleId) {
        /**
         * 1.根据文章id在comment表中查询评论
         * 2.根据作者id查询作者信息
         * 3.查询子评论
         * 4.如果有 根据评论id  进行查询(parent_id)
         * */
        LambdaQueryWrapper<Comment> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getArticleId,articleId);
        queryWrapper.eq(Comment::getLevel,1);

        List<Comment> commentList = commentMapper.selectList(queryWrapper);
        return Result.ok(copyList(commentList));
    }

    private List<CommentVo> copyList(List<Comment> commentList) {
        List<CommentVo> commentVoList=new ArrayList<>();
        for (Comment comment : commentList) {
            commentVoList.add(copy(comment));
        }
        return commentVoList;
    }

    private CommentVo copy(Comment comment) {
        CommentVo commentVo = BeanUtil.copyProperties(comment, CommentVo.class);
        commentVo.setId(comment.getId());
        UserVo author = sysUserService.findUserVoByAuthorId(comment.getAuthorId());
        //保存作者信息
        commentVo.setAuthor(author);

        //查询子评论
        List<CommentVo> commentVoList = findCommentByParentId(comment.getId());
        commentVo.setChildrens(commentVoList);

        // to User 给谁评论
        UserVo toUserVO = this.sysUserService.findUserVoByAuthorId(comment.getToUid());
        commentVo.setToUser(toUserVO);
        return commentVo;
    }

    private List<CommentVo> findCommentByParentId(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        // 设置查询条件
        queryWrapper.eq(Comment::getParentId, id);
        queryWrapper.eq(Comment::getLevel, 2);
        // 执行查询
        return copyList(commentMapper.selectList(queryWrapper));
    }

    @Override
    public Result createComment(CommentParam commentParam) {
        SysUser sysUser = UserThreadLocal.get();
        if(sysUser==null){
            return Result.fail("请先登录");
        }
        Comment comment = new Comment();

        //保存信息
        comment.setArticleId(commentParam.getArticleId());
        comment.setContent(commentParam.getContent());
        comment.setId(sysUser.getId());

        //通过文章id查询文章详细信息
        Article article = articleMapper.selectById(commentParam.getArticleId());

        // 如果该评论没有父评论则将该评论设为父评论，否则为子评论
        if ((commentParam.getParent() == null || commentParam.getParent() == 0) && (commentParam.getToUserId() == null || commentParam.getToUserId() == 0)) {
            comment.setLevel(1);
            comment.setToUid(article.getAuthorId());
        } else{
            comment.setLevel(2);
            comment.setParentId(commentParam.getParent());
            comment.setToUid(commentParam.getToUserId());
        }
        comment.setCreateDate(new Date());

        //插入数据
        commentMapper.insert(comment);

//        // 获取该文章id在评论表中的个数
//        CommentCountVO commentCountVO = commentMapper.queryArticleIdCount(commentParam.getArticleId());
//        // 更新文章的评论个数
//        threadService.updateCommentCount(commentCountVO);
        return Result.ok("发表评论成功");
    }
}
