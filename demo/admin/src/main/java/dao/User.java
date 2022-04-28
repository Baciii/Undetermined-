package dao;

import lombok.Data;

/**
 * @author wzk
 * @date 2022/4/28 18:22
 */
@Data
public class User {
    private Long id;

    private String account;

    private String password;

}
