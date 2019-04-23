package com.stech.tcip.schedule.dto;

/**
 * 定时任务dto类
 * @author Aimer
 *
 */
public class ScheduleDTO {
	
	/**
	 * id
	 */
	private String id;
	/**
	 * 任务名
	 */
	private String name;
	/**
	 * cron表达式
	 */
	private String exportCron;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 运行时长
	 */
	private String runTime; 
	/**
	 * 状态（0：未运行，1：运行中,2:运行完成）
	 */
	private String status;
	/**
	 * 调用类型（0：手动，1：周期）
	 */
	private String type;
	/**
	 * 创建人id
	 */
	private String createUserId;
	/**
	 * 机构id
	 */
	private String dataorgid;
	/**
	 * 银行代码(GS:工商银行,ZG:中国银行,JS:建设银行,NY:农业银行,YZ:邮政储蓄,JT:交通银行)
	 */
	private String bankCode;
	/**
	 * 生效次数
	 */
	private String repeatCount;
	/**
	 * 分公司code
	 */
	private String orgCode;
	/**
	 * tcis3.0Api服务代码 
	 */
	private String tcisCode;
	/**
	 * 机构名称
	 */
	private String orgName;
	
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getTcisCode() {
        return tcisCode;
    }
    public void setTcisCode(String tcisCode) {
        this.tcisCode = tcisCode;
    }
	public String getOrgCode() {
        return orgCode;
    }
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getDataorgid() {
		return dataorgid;
	}
	public void setDataorgid(String dataorgid) {
		this.dataorgid = dataorgid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExportCron() {
		return exportCron;
	}
	public void setExportCron(String exportCron) {
		this.exportCron = exportCron;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
    public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getRepeatCount() {
        return repeatCount;
    }
    public void setRepeatCount(String repeatCount) {
        this.repeatCount = repeatCount;
    }
    @Override
    public String toString() {
        return "ScheduleDTO [id=" + id + ", name=" + name + ", exportCron=" + exportCron + ", startTime=" + startTime + ", runTime=" + runTime
                + ", status=" + status + ", type=" + type + ", createUserId=" + createUserId + ", dataorgid=" + dataorgid + ", bankCode=" + bankCode
                + ", repeatCount=" + repeatCount + ", orgCode=" + orgCode + ", tcisCode=" + tcisCode + ", orgName=" + orgName + "]";
    }
}
