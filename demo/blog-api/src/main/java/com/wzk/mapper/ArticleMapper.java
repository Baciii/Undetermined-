package com.wzk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzk.dao.Archives;
import com.wzk.dao.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzk
 * @date 2022/5/1 21:12
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();
}
