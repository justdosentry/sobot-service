package com.iqianjin.sobotservice.controller;

import com.iqianjin.sobotservice.aop.SystemControllerLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HealthController
 * @Description 健康检查
 * @Author zhaozihui
 * @Date 2019/7/12 下午5:01
 * @Version 1.0
 */
@RestController("/")
@Slf4j
public class HealthController {

  @SystemControllerLog(description = "健康检查")
  @RequestMapping("health")
  public String health(String str,String asv) {
    return "success";
  }
}
