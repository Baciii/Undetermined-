package com.wzk.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.wzk.dao.Category;
import com.wzk.dto.ArticleCategoryVo;
import com.wzk.mapper.CategoryMapper;
import com.wzk.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wzk
 * @date 2022/5/14 22:36
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public ArticleCategoryVo findCategoryById(Long categoryId) {
        Category category = categoryMapper.selectById(categoryId);
        ArticleCategoryVo articleCategoryVo = BeanUtil.copyProperties(category, ArticleCategoryVo.class);
        return articleCategoryVo;
    }
}
