package com.iqianjin.sobotservice.entity;

import java.util.List;

/**
 * @ClassName EvaluateInfo
 * @Description TODO
 * @Author zhaozihui
 * @Date 2019/7/12 下午2:18
 * @Version 1.0
 */
public class EvaluateInfo {


  /**
   * type : evaluation
   * content : [{"companyId":"5cc2c708202d4defaf72d4bcac362a55","staffId":"9517","source":0,"adminName":null,"isRobot":true,"remark":"审核没通过","tag":"答非所问,问题不能回答","score":0,"visitorId":"97b31cba87e04dcdafe0ebb60248ecf4","datetime":1468340203266,"cid":"9ae05bc279544b68895cd86b12e418e0"}]
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
     * staffId : 9517
     * source : 0
     * adminName : null
     * isRobot : true
     * remark : 审核没通过
     * tag : 答非所问,问题不能回答
     * score : 0
     * visitorId : 97b31cba87e04dcdafe0ebb60248ecf4
     * datetime : 1468340203266
     * cid : 9ae05bc279544b68895cd86b12e418e0
     */

    private String companyId;
    private String staffId;
    private int source;
    private String adminName;
    private boolean isRobot;
    private String remark;
    private String tag;
    private int score;
    private String visitorId;
    private long datetime;
    private String cid;

    public String getCompanyId() {
      return companyId;
    }

    public void setCompanyId(String companyId) {
      this.companyId = companyId;
    }

    public String getStaffId() {
      return staffId;
    }

    public void setStaffId(String staffId) {
      this.staffId = staffId;
    }

    public int getSource() {
      return source;
    }

    public void setSource(int source) {
      this.source = source;
    }

    public String getAdminName() {
      return adminName;
    }

    public void setAdminName(String adminName) {
      this.adminName = adminName;
    }

    public boolean isIsRobot() {
      return isRobot;
    }

    public void setIsRobot(boolean isRobot) {
      this.isRobot = isRobot;
    }

    public String getRemark() {
      return remark;
    }

    public void setRemark(String remark) {
      this.remark = remark;
    }

    public String getTag() {
      return tag;
    }

    public void setTag(String tag) {
      this.tag = tag;
    }

    public int getScore() {
      return score;
    }

    public void setScore(int score) {
      this.score = score;
    }

    public String getVisitorId() {
      return visitorId;
    }

    public void setVisitorId(String visitorId) {
      this.visitorId = visitorId;
    }

    public long getDatetime() {
      return datetime;
    }

    public void setDatetime(long datetime) {
      this.datetime = datetime;
    }

    public String getCid() {
      return cid;
    }

    public void setCid(String cid) {
      this.cid = cid;
    }
  }
}
