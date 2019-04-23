package com.stech.tcip.sys.pojo;

import java.util.Date;

public class Accesstoken implements java.io.Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 9163344736116656260L;

	private Integer pkid;

    private String appid;
    
    private String orgcode;

    private Integer dataorgid;

    private String expiredate;

    private String secret;

    private String accesstoken;
    
    private String area;
    
    private String url;

    private Integer state;

    private Date createtime;

    private String createby;

    private Date lastmodifytime;

    private String modifyby;

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public Integer getDataorgid() {
        return dataorgid;
    }

    public void setDataorgid(Integer dataorgid) {
        this.dataorgid = dataorgid;
    }

    public String getExpiredate() {
		return expiredate;
	}

	public void setExpiredate(String expiredate) {
		this.expiredate = expiredate;
	}

	public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken == null ? null : accesstoken.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getModifyby() {
        return modifyby;
    }

    public void setModifyby(String modifyby) {
        this.modifyby = modifyby == null ? null : modifyby.trim();
    }

	@Override
	public String toString() {
		return "Accesstoken [pkid=" + pkid + ", appid=" + appid + ", orgcode=" + orgcode + ", dataorgid=" + dataorgid + ", expiredate=" + expiredate + ", secret=" + secret + ", accesstoken="
				+ accesstoken + ", state=" + state + ", createtime=" + createtime + ", createby=" + createby + ", lastmodifytime=" + lastmodifytime + ", modifyby=" + modifyby + "]";
	}
    
    
}