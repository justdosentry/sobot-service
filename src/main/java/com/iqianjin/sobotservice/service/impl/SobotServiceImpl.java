package com.iqianjin.sobotservice.service.impl;

import com.iqianjin.sobotservice.aop.SystemServiceLog;
import com.iqianjin.sobotservice.dao.SobotMapper;
import com.iqianjin.sobotservice.entity.ChatMessage;
import com.iqianjin.sobotservice.entity.EvaluateInfo;
import com.iqianjin.sobotservice.service.SobotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SobotServiceImpl
 * @Description TODO
 * @Author zhaozihui
 * @Date 2019/7/12 下午6:57
 * @Version 1.0
 */
@Slf4j
@Service
public class SobotServiceImpl implements SobotService {

  @Autowired
  SobotMapper sobotMapper;

  @Override
  @SystemServiceLog(description = "保存聊天信息")
  public void saveChatMsg(ChatMessage chatMessage) {
    sobotMapper.saveChatMessage(chatMessage.getContent());
  }

  @Override
  @SystemServiceLog(description = "保存评价信息")
  public void saveEvaInfo(EvaluateInfo evaluateInfo) {

  }
}
