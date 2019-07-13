package com.iqianjin.sobotservice.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName SystemLogAspect
 * @Description TODO
 * @Author zhaozihui
 * @Date 2019/7/12 下午6:38
 * @Version 1.0
 */
@Aspect
@Component
@SuppressWarnings("all")
@Slf4j
public class SystemLogAspect {

  //Service层切点
  @Pointcut("@annotation(com.iqianjin.sobotservice.aop.SystemServiceLog)")
  public void serviceAspect(){
  }

  //Controller层切点
  @Pointcut("@annotation(com.iqianjin.sobotservice.aop.SystemControllerLog)")
  public void controllerAspect(){
  }

  /**
   * @Description  前置通知  用于拦截Controller层记录用户的操作
   * @date 2018年9月3日 10:38
   */

  @Before("controllerAspect()")
  public void doBefore(JoinPoint joinPoint){
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    HttpSession session = request.getSession();
    //读取session中的用户
//    User user = (User) session.getAttribute("user");

//    String ip = IpUtils.getIpAddr(request);

    try {
      //*========控制台输出=========*//
      log.info("==============前置通知开始==============");
      log.info("请求方法" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
      log.info("方法描述：" + getControllerMethodDescription(joinPoint));
      String params = "";
      if (joinPoint.getArgs()!=null&&joinPoint.getArgs().length>0){
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
          params+= JSON.toJSONString(joinPoint.getArgs()[i])+";";
        }
      }
      log.info("参数：" + params);
//      log.info("请求人："+user.getUsername());
//      log.info("请求ip："+ip);
      

    }catch (Exception e){
      //记录本地异常日志
      log.error("==前置通知异常==");
      log.error("异常信息：{}",e.getMessage());
    }
  }

  /**
   * @Description  异常通知 用于拦截service层记录异常日志
   * @date 2018年9月3日 下午5:43
   */
  @AfterThrowing(pointcut = "serviceAspect()",throwing = "e")
  public void doAfterThrowing(JoinPoint joinPoint,Throwable e){
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    HttpSession session = request.getSession();
    //读取session中的用户
//    User user = (User) session.getAttribute("user");
//    //获取请求ip
//    String ip = IpUtils.getIpAddr(request);
    //获取用户请求方法的参数并序列化为JSON格式字符串
    String params = "";
    if (joinPoint.getArgs()!=null&&joinPoint.getArgs().length>0){
      for (int i = 0; i < joinPoint.getArgs().length; i++) {
        params+= joinPoint.getArgs()[i]+";";
      }
    }
    try{
      /*========控制台输出=========*/
      log.info("=====异常通知开始=====");
      log.info("异常代码:" + e.getClass().getName());
      log.info("异常信息:" + e.getMessage());
      log.info("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
      log.info("方法描述:" + getServiceMethodDescription(joinPoint));
//      log.info("请求人:" + user.getUsername());
//      log.info("请求IP:" + ip);
      log.info("请求参数:" + params);
    }catch (Exception ex){
      //记录本地异常日志
      log.error("==异常通知异常==");
      log.error("异常信息:{}", ex.getMessage());
    }
  }


  /**
   * @Description  获取注解中对方法的描述信息 用于service层注解
   * @date 2018年9月3日 下午5:05
   */
  public static String getServiceMethodDescription(JoinPoint joinPoint)throws Exception{
    String targetName = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    Object[] arguments = joinPoint.getArgs();
    Class targetClass = Class.forName(targetName);
    Method[] methods = targetClass.getMethods();
    String description = "";
    for (Method method:methods) {
      if (method.getName().equals(methodName)){
        Class[] clazzs = method.getParameterTypes();
        if (clazzs.length==arguments.length){
          description = method.getAnnotation(SystemServiceLog.class).description();
          break;
        }
      }
    }
    return description;
  }



  /**
   * @author changyaofang
   * @Description  获取注解中对方法的描述信息 用于Controller层注解
   * @date 2018年9月3日 上午12:01
   */
  public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
    String targetName = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();//目标方法名
    Object[] arguments = joinPoint.getArgs();
    Class targetClass = Class.forName(targetName);
    Method[] methods = targetClass.getMethods();
    String description = "";
    for (Method method:methods) {
      if (method.getName().equals(methodName)){
        Class[] clazzs = method.getParameterTypes();
        if (clazzs.length==arguments.length){
          description = method.getAnnotation(SystemControllerLog.class).description();
          break;
        }
      }
    }
    return description;
  }
}
