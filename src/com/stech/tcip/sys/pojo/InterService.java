package com.stech.tcip.sys.pojo;

public class InterService {
    private String id;

    private String tciscode;

    private String tcipcode;

    private String type;

    private String name;

    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTciscode() {
        return tciscode;
    }

    public void setTciscode(String tciscode) {
        this.tciscode = tciscode == null ? null : tciscode.trim();
    }

    public String getTcipcode() {
        return tcipcode;
    }

    public void setTcipcode(String tcipcode) {
        this.tcipcode = tcipcode == null ? null : tcipcode.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}