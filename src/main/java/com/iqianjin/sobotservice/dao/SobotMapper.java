package com.iqianjin.sobotservice.dao;

import com.iqianjin.sobotservice.entity.ChatMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SobotMapper {

  public void saveChatMessage(@Param("contentBeanList") List<ChatMessage.ContentBean> contentBeanList);

}
