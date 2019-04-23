package com.stech.tcip.event.pojo;

import java.util.Date;

public class Eventreg {
    private Integer id;

    private String messagecode;

    private String url;

    private String token;

    private String type;

    private String appid;

    private Integer cancelflag;

    private Date createtime;

    private Date lastmodifytime;
    
    private String dataorgid;
    
    public Eventreg() {
		super();
	}

	public Eventreg(String messagecode, String type, String appid) {
		super();
		this.messagecode = messagecode;
		this.type = type;
		this.appid = appid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessagecode() {
        return messagecode;
    }

    public void setMessagecode(String messagecode) {
        this.messagecode = messagecode == null ? null : messagecode.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public Integer getCancelflag() {
        return cancelflag;
    }

    public void setCancelflag(Integer cancelflag) {
        this.cancelflag = cancelflag;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

	public String getDataorgid() {
		return dataorgid;
	}

	public void setDataorgid(String dataorgid) {
		this.dataorgid = dataorgid;
	}
    
}