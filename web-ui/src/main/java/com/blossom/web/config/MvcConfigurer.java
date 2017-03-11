package com.blossom.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @description:
 * @author Blossom
 * @time 2017年3月10日 下午5:09:58
 */
@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {

	/**
	 * @description:
	 * @author Blossom
	 * @time 2017年3月10日 下午5:11:04
	 * @see WebMvcConfigurerAdapter#addViewControllers(ViewControllerRegistry)
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/error").setViewName("error.html");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	/**
	 * @description:
	 * @author Blossom
	 * @time 2017年3月10日 下午5:11:04
	 * @see WebMvcConfigurerAdapter#configurePathMatch(PathMatchConfigurer)
	 * @param configurer
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {

		super.configurePathMatch(configurer);
		configurer.setUseSuffixPatternMatch(false);
	}

	/**
	 * @description:静态资源文件处理
	 * @author Blossom
	 * @time 2017年3月10日 下午5:39:10
	 * @see WebMvcConfigurerAdapter#addResourceHandlers(ResourceHandlerRegistry)
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		super.addResourceHandlers(registry);
		//registry.addResourceHandler("/mystatic/**").addResourceLocations("classpath:/mystatic/");
	}

	
}
