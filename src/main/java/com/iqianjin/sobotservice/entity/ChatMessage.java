package com.iqianjin.sobotservice.entity;

import java.util.List;

/**
 * @ClassName ChatMessage
 * @Description TODO
 * @Author zhaozihui
 * @Date 2019/7/12 下午2:18
 * @Version 1.0
 */
public class ChatMessage {


  /**
   * type : msg
   * content : [{"companyId":"5cc2c708202d4defaf72d4bcac362a55","cid":"44c603626e2e4c82a5a49619a8aaa397","time":"2016-07-18 15:30:16","senderName":"冯建武","receiverName":null,"msg":"到还款日，延期3天怎么算"}]
   */

  private String type;
  private List<ContentBean> content;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<ContentBean> getContent() {
    return content;
  }

  public void setContent(List<ContentBean> content) {
    this.content = content;
  }

  public static class ContentBean {
    /**
     * companyId : 5cc2c708202d4defaf72d4bcac362a55
     * cid : 44c603626e2e4c82a5a49619a8aaa397
     * time : 2016-07-18 15:30:16
     * senderName : 冯建武
     * receiverName : null
     * msg : 到还款日，延期3天怎么算
     */

    private String companyId;
    private String cid;
    private long timems;
    private String time;
    private String senderName;
    private String receiverName;
    private int senderType;
    private int receiverType;
    private String msg;

    public String getCompanyId() {
      return companyId;
    }

    public void setCompanyId(String companyId) {
      this.companyId = companyId;
    }

    public String getCid() {
      return cid;
    }

    public void setCid(String cid) {
      this.cid = cid;
    }

    public String getTime() {
      return time;
    }

    public void setTime(String time) {
      this.time = time;
    }

    public String getSenderName() {
      return senderName;
    }

    public void setSenderName(String senderName) {
      this.senderName = senderName;
    }

    public String getReceiverName() {
      return receiverName;
    }

    public void setReceiverName(String receiverName) {
      this.receiverName = receiverName;
    }

    public String getMsg() {
      return msg;
    }

    public void setMsg(String msg) {
      this.msg = msg;
    }

    public long getTimems() {
      return timems;
    }

    public void setTimems(long timems) {
      this.timems = timems;
    }

    public int getSenderType() {
      return senderType;
    }

    public void setSenderType(int senderType) {
      this.senderType = senderType;
    }

    public int getReceiverType() {
      return receiverType;
    }

    public void setReceiverType(int receiverType) {
      this.receiverType = receiverType;
    }
  }
}
