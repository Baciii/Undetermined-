package com.wzk.dto;

import lombok.Data;

/**
 * @author wzk
 * @date 2022/5/2 16:07
 */
@Data
public class LoginUserVo {
    private Long id;
    private String account;
    private String nickname;
    private String avatar;
}
