package com.wzk.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzk.dao.Tag;
import com.wzk.dto.Result;
import com.wzk.dto.TagVo;
import com.wzk.mapper.TagMapper;
import com.wzk.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wzk
 * @date 2022/5/1 22:06
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        List<Tag> tags = tagMapper.findTagsByArticleId(id);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {

        //最热标签
        //1. 首先该标签下所拥有的文章应该是最多的 (分组查询)
        //2. 查询 根据tag_id 分组 计数，从大到小 排列 去前六个
        List<Long> tagIds = tagMapper.findHotTagsIds(limit);

        if(CollectionUtils.isEmpty(tagIds)){
            return Result.fail("标签id为空");
        }
        //需求是返回tagName 即Tag对象
        List<Tag> tags = tagMapper.findTagsByTagsIds(tagIds);
        return Result.ok(tags);
    }

    private List<TagVo> copyList(List<Tag> tags) {
        List<TagVo> tagVos = new ArrayList<>();
        for(Tag tag : tags){
            tagVos.add(copy(tag));
        }
        return tagVos;
    }
    private TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtil.copyProperties(tagVo,tag);
        return tagVo;
    }
}
