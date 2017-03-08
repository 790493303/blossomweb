package com.blossom.web.shiro;

import com.blossom.web.shiro.filter.URLPermissionsFilter;
import com.blossom.web.shiro.realm.ShiroRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Blossom
 * @Description shiro配置
 * @time 2017/3/7 10:35
 */
@Configuration
public class ShiroConfig {

    /**
     * @description 过滤器链
     * @author Blossom
     * @DateTime 2017/3/7 10:36
     *
     **/
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
    }

    /**
     * @description shiro 过滤器
     * @author Blossom
     * @DateTime 2017/3/7 10:40
     *
     **/
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/login");
        bean.setUnauthorizedUrl("/unauthor");

        Map<String,Filter> filters = new HashMap<>();
        filters.put("perms",urlPermissionFilter());
        filters.put("anon",new AnonymousFilter());
        bean.setFilters(filters);

        Map<String,String> chains = new HashMap<>();
        chains.put("/login","anon");
        chains.put("/logout", "logout");
        chains.put("/base/**", "anon");
        chains.put("/css/**", "anon");
        chains.put("/layer/**", "anon");
        chains.put("/**", "authc,perms");
        bean.setFilterChainDefinitionMap(chains);
        return bean;
    }

    /**
     * @description
     * @author Blossom
     * @DateTime 2017/3/7 10:46
     *
     **/
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(shiroRealm());
        manager.setCacheManager(cacheManager());
        manager.setSessionManager(defaultWebSessionManager());
        return manager;
    }

    /**
     * @description
     * @author Blossom
     * @DateTime 2017/3/7 10:51
     *
     **/
    @Bean(name = "sessionManager")
    public DefaultWebSessionManager defaultWebSessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setCacheManager(cacheManager());
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }

    /**
     * @description
     * @author Blossom
     * @DateTime 2017/3/7 10:53
     *
     **/
    @Bean
    @DependsOn(value = "lifecycleBeanPostProcessor")
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCacheManager(cacheManager());
        return shiroRealm;
    }

    @Bean
    public URLPermissionsFilter urlPermissionFilter(){
        return new URLPermissionsFilter();
    }

    @Bean
    public EhCacheManager cacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return cacheManager;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

}
