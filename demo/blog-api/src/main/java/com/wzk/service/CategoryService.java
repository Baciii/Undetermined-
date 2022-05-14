package com.wzk.service;

import com.wzk.dto.ArticleCategoryVo;


/**
 * @author wzk
 * @date 2022/5/14 22:36
 */
public interface CategoryService {
    ArticleCategoryVo findCategoryById(Long categoryId);
}
