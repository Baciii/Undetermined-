package com.wzk.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author wzk
 * @date 2022/5/14 23:27
 */
@Data
public class UserVo {
    private String nickname;

    private String avatar;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
}
