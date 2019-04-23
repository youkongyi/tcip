package com.stech.tcip.schedule.dto;

public class WithholdSchedule {
    
    private String appid;
    
    private String url;
    
    private String orgcode;
    
    private String dataorgid;
    
    private String state;
    
    private String messageid;
    
    public String getMessageid() {
        return messageid;
    }
    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getAppid() {
        return appid;
    }
    public void setAppid(String appid) {
        this.appid = appid;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getOrgcode() {
        return orgcode;
    }
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }
    public String getDataorgid() {
        return dataorgid;
    }
    public void setDataorgid(String dataorgid) {
        this.dataorgid = dataorgid;
    }
    
}
