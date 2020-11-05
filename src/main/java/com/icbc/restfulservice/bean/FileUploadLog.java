package com.icbc.restfulservice.bean;

import java.sql.Timestamp;

public class FileUploadLog {
    private int id;
    private String aduser;
    private String ipaddress;
    private String fileContext;
    private long time;
    private String RandomCode;

    public String getFileContext() {
        return fileContext;
    }

    public void setFileContext(String fileContext) {
        this.fileContext = fileContext;
    }

    public String getRandomCode() {
        return RandomCode;
    }

    public void setRandomCode(String randomCode) {
        RandomCode = randomCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAduser() {
        return aduser;
    }

    public void setAduser(String aduser) {
        this.aduser = aduser;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
