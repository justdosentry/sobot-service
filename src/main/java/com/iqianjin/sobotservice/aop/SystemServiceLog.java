package com.iqianjin.sobotservice.aop;

import java.lang.annotation.*;

/**
 * @ClassName SystemServiceLog
 * @Description TODO
 * @Author zhaozihui
 * @Date 2019/7/12 下午6:38
 * @Version 1.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
  String description() default "";
}
