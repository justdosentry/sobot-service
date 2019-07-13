package com.iqianjin.sobotservice.service;

import com.iqianjin.sobotservice.entity.ChatMessage;
import com.iqianjin.sobotservice.entity.EvaluateInfo;

public interface SobotService {

  public void saveChatMsg(ChatMessage chatMessage);

  public void saveEvaInfo(EvaluateInfo evaluateInfo);
}
