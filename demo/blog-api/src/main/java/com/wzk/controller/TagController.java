package com.wzk.controller;

import com.wzk.dto.Result;
import com.wzk.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wzk
 * @date 2022/5/1 22:43
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/hots")
    public Result hots(){
        int limit=6;
        return tagService.hots(limit);
    }
}
