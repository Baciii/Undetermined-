package com.example.demo.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wzk
 * @date 2022/4/29 12:45
 */
@Data
public class User implements Serializable {
    @TableId(value = "u_id",type = IdType.AUTO)
    private Long Id;

    private String account;

    private String password;
}
