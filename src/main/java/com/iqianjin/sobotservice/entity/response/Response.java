package com.iqianjin.sobotservice.entity.response;

import java.util.HashMap;
import java.util.Map;

/** 
* @author shuwei 
* @version 创建时间：2018年10月19日 下午2:06:31 
* 类说明 
*/
public class Response {
  public static final int SUCCESS = 1;
  public static final int ERROR = -1;
  
  private int code;
  private String message;
  private Object data;
  
  public static Response fail(String message) {
    Response res = new Response();
    res.setCode(ERROR);
    res.setMessage(message);
    return res;
  }
  
  public static Response success(String message, Object data) {
    Response res = new Response();
    res.setCode(SUCCESS);
    res.setMessage(message);
    res.setData(data);
    return res;
  }
  
  public static Response success(Object data) {
    Response res = new Response();
    res.setCode(SUCCESS);
    res.setMessage("成功");
    res.setData(data);
    return res;
  }
  
  public static Response success(long count, Object list) {
    Map<String, Object> data = new HashMap<>();
    data.put("count", count);
    data.put("list", list);
    return success(data);
  }
  
  public static Response success() {
    Response res = new Response();
    res.setCode(SUCCESS);
    res.setMessage("成功");
    return res;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
