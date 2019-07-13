package com.iqianjin.sobotservice.controller;

import com.alibaba.fastjson.JSON;
import com.iqianjin.sobotservice.aop.SystemControllerLog;
import com.iqianjin.sobotservice.entity.ChatMessage;
import com.iqianjin.sobotservice.entity.response.Response;
import com.iqianjin.sobotservice.service.SobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Author zhaozihui
 * @Date 2019/7/12 下午5:32
 * 智齿服务接口
 */
@RestController("/thirdparty/opsigenes")
//@RestController("/")
public class SobotController {

  @Autowired
  SobotService sobotService;


  //保存聊天消息
  @ResponseBody
  @RequestMapping(value = "/saveChatMsg")
  @SystemControllerLog(description = "保存聊天消息")
  public Object saveChatMsg(@RequestParam("msg") String msg){
    try {
      if (StringUtils.isEmpty(msg)) {
        return Response.fail("参数为null");
      }
      ChatMessage chatMessage = JSON.parseObject(msg, ChatMessage.class);
      sobotService.saveChatMsg(chatMessage);
      return Response.success();
    } catch (Exception e) {
      e.printStackTrace();
      return Response.fail(e.getMessage());
    }
  }

}
