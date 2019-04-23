package com.stech.tcip.schedule.dto;

public class BankSchedule {

    private String id;
    
    private String scheduleId;
    
    private String dataorgid;
    
    private String orgCode;
    
    private String bankCode;

    private String flowNo;

    private String fileNameInput;
    
    private String fileNameBack;
    
    private String fileInputSize;
    
    private String fileBackSize;
    
    private String createDate;
    
    private String backDate;

    private String stastus;
    
    public String getDataorgid() {
        return dataorgid;
    }

    public void setDataorgid(String dataorgid) {
        this.dataorgid = dataorgid;
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

    public String getStastus() {
        return stastus;
    }

    public void setStastus(String stastus) {
        this.stastus = stastus;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getFileNameInput() {
        return fileNameInput;
    }

    public void setFileNameInput(String fileNameInput) {
        this.fileNameInput = fileNameInput;
    }

    public String getFileNameBack() {
        return fileNameBack;
    }

    public void setFileNameBack(String fileNameBack) {
        this.fileNameBack = fileNameBack;
    }

    public String getFileInputSize() {
        return fileInputSize;
    }

    public void setFileInputSize(String fileInputSize) {
        this.fileInputSize = fileInputSize;
    }

    public String getFileBackSize() {
        return fileBackSize;
    }

    public void setFileBackSize(String fileBackSize) {
        this.fileBackSize = fileBackSize;
    }

    public String getBackDate() {
        return backDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }

    @Override
    public String toString() {
        return "BankSchedule [id=" + id + ", scheduleId=" + scheduleId + ", fileNameInput=" + fileNameInput + ", fileNameBack=" + fileNameBack
                + ", fileInputSize=" + fileInputSize + ", fileBackSize=" + fileBackSize + ", createDate=" + createDate + ", backDate=" + backDate
                + ", flowNo=" + flowNo + ", stastus=" + stastus + ", bankCode=" + bankCode + "]";
    }
}
