package com.iqianjin.sobotservice.aop;

import java.lang.annotation.*;

/**
 * @ClassName SystemControllerLog
 * @Description TODO
 * @Author zhaozihui
 * @Date 2019/7/12 下午6:36
 * @Version 1.0
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})//作用在参数和方法上
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Documented//表明这个注解应该被 javadoc工具记录
public @interface SystemControllerLog {
  String description() default "";
}
