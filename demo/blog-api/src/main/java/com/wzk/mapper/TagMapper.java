package com.wzk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzk.dao.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzk
 * @date 2022/5/1 21:17
 */
@Repository
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据文章id查询标签列表
     * @param id
     * @return
     */
    List<Tag> findTagsByArticleId(Long id);

    /**
     * 查询最热标签 前limit条
     * @param limit
     * @return
     */
    List<Long> findHotTagsIds(int limit);

    List<Tag> findTagsByTagsIds(List<Long> tagsIds);
}
