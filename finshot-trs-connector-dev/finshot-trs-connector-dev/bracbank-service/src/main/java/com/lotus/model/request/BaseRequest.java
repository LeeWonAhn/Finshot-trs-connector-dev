package com.lotus.model.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class BaseRequest {
    private String userName;

    private String exPassword;

    private String exCode;

    private Date enteredDatetime;

    public BaseRequest(String userName, String exPassword, String exCode, Date enteredDatetime) {
        this.userName = userName;
        this.exPassword = exPassword;
        this.exCode = exCode;
        this.enteredDatetime = enteredDatetime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExPassword() {
        return exPassword;
    }

    public void setExPassword(String exPassword) {
        this.exPassword = exPassword;
    }

    public String getExCode() {
        return exCode;
    }

    public void setExCode(String exCode) {
        this.exCode = exCode;
    }

    public Date getEnteredDatetime() {
        return enteredDatetime;
    }

    public void setEnteredDatetime(Date enteredDatetime) {
        this.enteredDatetime = enteredDatetime;
    }
}
