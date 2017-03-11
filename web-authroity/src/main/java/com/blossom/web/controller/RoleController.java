package com.blossom.web.controller;

import com.blossom.web.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Blossom
 * @Description 角色访问API接口
 * @time 2017/3/9 11:56
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource(name = "roleService")
    private IRoleService roleService;

}
