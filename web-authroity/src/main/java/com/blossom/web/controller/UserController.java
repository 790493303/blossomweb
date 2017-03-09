package com.blossom.web.controller;

import com.blossom.web.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Blossom
 * @Description 用户访问API接口
 * @time 2017/3/9 11:55
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;



}
