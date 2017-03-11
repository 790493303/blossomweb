package com.blossom.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Blossom
 * @Description 权限管理模块启动入口
 * @time 2017/3/6 22:28
 */
@SpringBootApplication
public class ApplicationContextMain {

    /**
     * @description 启动方法
     * @author Blossom
     * @DateTime 2017/3/6 22:29
     *
     **/
    public static void main(String[]args){
        SpringApplication.run(ApplicationContextMain.class,args);
    }

}
