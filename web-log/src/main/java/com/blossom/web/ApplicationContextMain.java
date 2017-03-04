package com.blossom.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @deprecated : 程序入口
 * Created by Blossom on 2017/3/1.
 */
@SpringBootApplication
public class ApplicationContextMain extends SpringBootServletInitializer{

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(ApplicationContextMain.class);
    }*/

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
