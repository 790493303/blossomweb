package com.blossom.web.controller;

import com.blossom.web.service.IAuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Blossom
 * @Description 权限访问API接口
 * @time 2017/3/9 11:57
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

    @Resource(name = "authorService")
    private IAuthorService authorService;

}
