package com.wzk.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzk.dao.Archives;
import com.wzk.dao.Article;
import com.wzk.dto.ArticleVo;
import com.wzk.dto.PageParams;
import com.wzk.dto.Result;
import com.wzk.mapper.ArticleMapper;
import com.wzk.service.ArticleService;
import com.wzk.service.SysUserService;
import com.wzk.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wzk
 * @date 2022/5/1 21:26
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private TagService tagService;

    @Resource
    private SysUserService sysUserService;

    @Override
    public Result listArticle(PageParams pageParams) {
        Page<Article> articlePage = new Page<>(pageParams.getPage(),pageParams.getPagesize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        //按置顶排序 按创建时间排序
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);


        Page<Article> selectPage = articleMapper.selectPage(articlePage, queryWrapper);
        List<Article> records = selectPage.getRecords();

        List<ArticleVo> articleVoList = copyList(records,true,true);
        return Result.ok(articleVoList);
    }

    @Override
    public Result hotArticle(int limit) {
        //select id,title from article order by view_counts desc limit 5
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit"+limit);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        return Result.ok(copyList(articles,false,false));
    }

    @Override
    public Result newArticle(int limit) {
        // select id,title from article order by create_time desc limit 5
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getCreateDate);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit"+limit);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        return Result.ok(copyList(articles,false,false));
    }

    @Override
    public Result listArchives() {
        //select year(create_data) as year,month(create_date)as month,count(*) as count from ms_article group by year,month
        List<Archives> archives = articleMapper.listArchives();
        return Result.ok(archives);
    }

    private List<ArticleVo> copyList(List<Article> records,boolean isTag,boolean isAuthor){
        List<ArticleVo> articleVoList = new ArrayList<>();
        for(Article record:records){
            articleVoList.add(copy(record,true,true));
        }
        return articleVoList;
    }


    private ArticleVo copy(Article article,boolean isTag,boolean isAuthor){
        //注意vo是datetime String  另外一个是Long
        ArticleVo articleVo = new ArticleVo();
        BeanUtil.copyProperties(article,articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));

        //并不是所有接口都需要标签，作者信息
        if(isTag){
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticleId(articleId));
        }
        if(isAuthor){
            Long authorId = article.getAuthorId();
            articleVo.setAuthor(sysUserService.findUserById(authorId).getNickname());
        }
        return articleVo;
    }
}
