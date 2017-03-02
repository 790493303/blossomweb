package com.blossom.web.controller;

import com.blossom.web.annotation.LogAnnotation;
import com.blossom.web.service.ILogService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Blossom
 * @Description log API接口
 * @time 2017/3/2 11:36
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Resource(name = "logService")
    private ILogService logService;

    @RequestMapping("/query")
    @ResponseBody
    @LogAnnotation(description = "queryAllLog")
    public JSONObject queryAllLog(HttpServletRequest request,
                                  HttpServletResponse response){
        JSONObject json = new JSONObject();
        json.put("status","1");
        json.put("message","HelloWorld！");
        return json;
    }

}
