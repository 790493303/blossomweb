package com.blossom.web.aspectj;

import com.blossom.web.annotation.LogAnnotation;
import com.blossom.web.service.ILogService;
import net.sf.json.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description service层切面
 * @author Blossom
 * @DateTime 2017/3/2 10:23
 *
 **/
@Aspect
@Component
public class LogAspectj {

    private static final Logger logger = LoggerFactory.getLogger(LogAspectj.class);

    @Resource(name = "logService")
    private ILogService logService;

    @Pointcut("@annotation(com.blossom.web.annotation.LogAnnotation)")
    public void serviceAspect(){}

    /**
     * Do before.
     *
     * @param joinPoint the join point
     * @user blossom
     * @DateTime 2017 /3/2
     * @deprecated :前置通知
     */
    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        /*UserModel user = (UserModel)session.getAttribute("user");
        if (ObjectUtils.isEmpty(user)) {
            user = new UserModel();
        }*/
        //获取请求IP
        String ip = request.getRemoteAddr();
        try {
            //*========控制台输出=========*//
            /*System.out.println("=====前置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
            System.out.println("请求人:" + user.getUserName());
            System.out.println("请求IP:" + ip); */
            //*========数据库日志=========*//
            //保存日志到数据库
            JSONObject json = new JSONObject();
            json.put("uuid", "1234567890");
            json.put("url", request.getRequestURL().toString());
            json.put("httpMethod",request.getMethod());
            //json.put("broswer",BrowserUtils.checkBrowse(request));
            json.put("broswer","google");
            json.put("description",getMthodDescription(joinPoint));
            json.put("exceptionCode","无异常");
            json.put("type", "0");
            json.put("exceptionDetail","无异常");
            json.put("method",(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            json.put("params",Arrays.toString(joinPoint.getArgs()));
            // json.put("createBy",user.getUserId());
            json.put("createBy","admin");
            // json.put("createDate",DateFormatUtil.getNow());
            json.put("createDate","1234567890");
            json.put("requestIp",ip );

            json = logService.insertLogInfo(json);
            System.out.println("return json=======" + json.toString());
            System.out.println("=====前置通知结束=====");
        } catch (Exception e) {
            //记录本地异常日志
            logger.error(e.getMessage());
            e.printStackTrace();
            System.out.print("异常信息: " + e.getMessage());
        }
    }

    /**
     * Do after throwing.
     *
     * @param joinPoint the join point
     * @param throwable the throwable
     * @user blossom
     * @DateTime 2017 /3/2
     * @deprecated 异常通知
     */
    @AfterThrowing(pointcut = "serviceAspect()",throwing = "throwable")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        // UserModel user = (UserModel)session.getAttribute("user");
        //if (ObjectUtils.isEmpty(user)) {
        //user = new UserModel();
        //}
        //获取请求IP
        String ip = request.getRemoteAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = Arrays.toString(joinPoint.getArgs());

        try {
              /*========控制台输出=========*/
            /*System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + throwable.getClass().getName());
            System.out.println("异常信息:" + throwable.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));
            System.out.println("请求人:" + user.getUserName());
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params); */
               /*==========数据库日志=========*/
            //保存数据库
            JSONObject json = new JSONObject();
           // json.put("uuid", MD5Utils.string2MD5(DateFormatUtil.getNow()));
            json.put("uuid", "1234567890");
            json.put("url", request.getRequestURL().toString());
            json.put("httpMethod",request.getMethod());
            //json.put("broswer",BrowserUtils.checkBrowse(request));
            json.put("broswer","google");
            json.put("description",getMthodDescription(joinPoint));
            json.put("exceptionCode",throwable.getClass().getName());
            json.put("type", "1");
            json.put("exceptionDetail",throwable.getMessage());
            json.put("method",(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            json.put("params",params);
           // json.put("createBy",user.getUserId());
            json.put("createBy","admin");
           // json.put("createDate",DateFormatUtil.getNow());
            json.put("createDate","1234567890");
            json.put("requestIp",ip );

            json = logService.insertLogInfo(json);
            System.out.println("return json====" + json.toString());
            System.out.println("=====异常通知结束=====");
        }  catch (Exception e) {
            //记录本地异常日志
            logger.error(e.getMessage());
            e.printStackTrace();
            System.out.print("异常信息: " + e.getMessage());
        }

    }

    /**
     * Do after returning.
     *
     * @param joinPoint the join point
     * @param result    the result
     * @user blossom
     * @DateTime 2017 /3/2
     * @deprecated 后置通知
     */
// @AfterReturning(pointcut = "joinPoint",returning = "result")
    public void doAfterReturning(JoinPoint joinPoint,String result){

    }

    /**
     * Do around.
     *
     * @param value the value
     * @user blossom
     * @DateTime 2017 /3/2
     * @deprecated 环绕通知
     */
//@Around(value = "value")
    public void doAround(String value){

    }

    /**
     * @description 获取注解当中参数的值
     * @author Blossom
     * @DateTime 2017/3/2 11:01
     *
     **/
    private String getMthodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(LogAnnotation.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
