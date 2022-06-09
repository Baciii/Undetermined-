package com.wzk.controller;

import cn.hutool.core.util.StrUtil;
import com.wzk.dto.Result;
import com.wzk.service.SysUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author wzk
 * @date 2022/5/2 15:40
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public static final String IMAGE_UPLOAD_DIR ="E:\\下载";

    @Resource
    private SysUserService sysUserService;

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    @GetMapping("/currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){
        return sysUserService.findUserByToken(token);
    }

    @PostMapping("/image")
    public Result uploadImage(@RequestParam("file") MultipartFile image) {
        try {
            // 获取原始文件名称
            String originalFilename = image.getOriginalFilename();
            // 生成新文件名
            String fileName = createNewFileName(originalFilename);
            // 保存文件
            image.transferTo(new File(IMAGE_UPLOAD_DIR, fileName));
            return Result.ok(fileName);
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败", e);
        }
    }

    private String createNewFileName(String originalFilename) {
        // 获取后缀
        String suffix = StrUtil.subAfter(originalFilename, ".", true);
        // 生成目录
        String name = UUID.randomUUID().toString();
        int hash = name.hashCode();
        int d1 = hash & 0xF;
        int d2 = (hash >> 4) & 0xF;
        // 判断目录是否存在
        File dir = new File(IMAGE_UPLOAD_DIR, StrUtil.format("/images/{}/{}", d1, d2));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 生成文件名
        return StrUtil.format("/images/{}/{}/{}.{}", d1, d2, name, suffix);
    }
}
