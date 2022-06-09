package com.wzk.dto.params;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author wzk
 * @date 2022/5/14 23:35
 */
@Data
public class CommentParam {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long articleId;

    private String content;

    private Long parent;

    private Long toUserId;
}
