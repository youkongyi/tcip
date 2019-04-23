package com.stech.tcip.event.pojo;

import java.util.Date;

public class Eventpushlog {
    private Integer id;

    private String pushcode;

    private String appid;

    private String url;

    private String status;

    private Date createtime;

    private String dataorgid;

    private byte[] message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPushcode() {
        return pushcode;
    }

    public void setPushcode(String pushcode) {
        this.pushcode = pushcode == null ? null : pushcode.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDataorgid() {
        return dataorgid;
    }

    public void setDataorgid(String dataorgid) {
        this.dataorgid = dataorgid == null ? null : dataorgid.trim();
    }

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }
}