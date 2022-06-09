package com.wzk.dto.params;

import lombok.Data;

/**
 * @author wzk
 * @date 2022/5/1 21:20
 */
@Data
public class PageParams {
    private int page=1;
    private int pagesize=10;
}
