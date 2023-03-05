package com.lotus.model.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SignatureRequest {
    private String signaturevalue;

    public SignatureRequest(String signaturevalue) {
        this.signaturevalue = signaturevalue;
    }

    public String getSignaturevalue() {
        return signaturevalue;
    }

    public void setSignaturevalue(String signaturevalue) {
        this.signaturevalue = signaturevalue;
    }
}
