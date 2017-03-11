package com.blossom.web.shiro.filter;

import com.blossom.web.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/7 11:09
 */
@Component("urlPermissionsFilter")
public class URLPermissionsFilter extends PermissionsAuthorizationFilter {

    @Resource(name = "userService")
    private IUserService userService;

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        String curUrl = getRequestUrl(request);
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipal() == null
                || StringUtils.endsWithAny(curUrl, ".js",".css",".html")
                || StringUtils.endsWithAny(curUrl, ".jpg",".png",".gif", ".jpeg")
                || StringUtils.equals(curUrl, "/unauthor")) {
            return true;
        }
        // userService.findPermissionUrl(subject.getPrincipal().toString());
        List<String> urls = new ArrayList<>();

        return urls.contains(curUrl);
    }

    /**
     * @description 获取当前URL+Parameter
     * @author Blossom
     * @DateTime 2017/3/7 11:10
     *
     **/
    private String getRequestUrl(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest)request;
        String queryString = req.getQueryString();

        queryString = StringUtils.isBlank(queryString)?"": "?"+queryString;
        return req.getRequestURI()+queryString;
    }
}
