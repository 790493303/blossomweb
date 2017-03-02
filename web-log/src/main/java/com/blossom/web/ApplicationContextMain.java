package com.blossom.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @deprecated : 程序入口
 * Created by Blossom on 2017/3/1.
 */
@SpringBootApplication
public class ApplicationContextMain {

    /**
     * @description 项目启动方法
     * @author Blossom
     * @DateTime 2017/3/2 17:33
     *
     */
    public static void main(String[]args){

        SpringApplication.run(ApplicationContextMain.class,args);
    }
}
