package com.icbc.restfulservice.bean;

import java.sql.Timestamp;

public class MsraId {
    private String hostname;
    private String xmlContext;
    private String password;
    private String adUser;
    private Timestamp timeStamp;
    private String randomCode;
    private String ip;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getXmlContext() {
        return xmlContext;
    }

    public void setXmlContext(String xmlContext) {
        this.xmlContext = xmlContext;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdUser() {
        return adUser;
    }

    public void setAdUser(String adUser) {
        this.adUser = adUser;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
