package com.wzk.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.wzk.dao.Tag;
import com.wzk.dto.Result;
import com.wzk.dto.TagVo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wzk
 * @date 2022/5/1 22:05
 */
public interface TagService extends IService<Tag> {
    List<TagVo> findTagsByArticleId(Long id);

    Result hots(int limit);
}
