package com.wzk.dao;

import lombok.Data;

/**
 * @author wzk
 * @date 2022/5/14 21:25
 */
@Data
public class Category {
    private Long id;
    private String avatar;
    private String categoryName;
    private String description;
}
