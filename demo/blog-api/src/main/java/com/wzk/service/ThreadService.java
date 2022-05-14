package com.wzk.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wzk.dao.Article;
import com.wzk.mapper.ArticleMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wzk
 * @date 2022/5/14 23:59
 */
@Component
@Transactional
public class ThreadService {
    @Resource
    private ArticleMapper articleMapper;

    // 此操作在线程池中进行 不会影响原有的主线程
    @Async("taskExecutor")
    public void updateViewCount(ArticleMapper articleMapper, Article article) {
        Article articleUpdate = new Article();
        // 阅读次数加1
        articleUpdate.setViewCounts(article.getViewCounts() + 1);
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        // 根据文章id更新
        queryWrapper.eq(Article::getId, article.getId());
        // 保证线程安全,乐观锁
        queryWrapper.eq(Article::getViewCounts, article.getViewCounts());
        // 执行更新操作
        articleMapper.update(articleUpdate, queryWrapper);
    }
}
