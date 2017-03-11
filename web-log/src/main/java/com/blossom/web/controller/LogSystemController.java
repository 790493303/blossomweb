package com.blossom.web.controller;

import com.blossom.web.annotation.ControllerLogAnnotation;
import com.blossom.web.service.ILogSystemService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 系统日志API接口
 * @author Blossom
 * @time 2017年3月2日 下午4:11:15
 */
@Controller
@RequestMapping("/systemLog")
public class LogSystemController {
	
	@Resource(name="logSystemServie")
	private ILogSystemService logSystemService;
	
	/**
	 * @Description: 获取日志 
	 * @author Blossom
	 * @time 2017年3月2日 下午4:14:24 
	 * @return_type JSONObject
	 *
	 */
	@RequestMapping("/query")
	@ControllerLogAnnotation(description="获取日志")
	public @ResponseBody JSONObject queryLogSystem(HttpServletRequest request,
			HttpServletResponse response){
		JSONObject json = new JSONObject();
		json = logSystemService.queryLogSystem(json);
		return json;
	}

	@RequestMapping("/index")
	public String returnIndex(HttpServletRequest request,
							  HttpServletResponse response,
							  Model model){
		model.addAttribute("admin","admin");
		return "index";
	}

}
