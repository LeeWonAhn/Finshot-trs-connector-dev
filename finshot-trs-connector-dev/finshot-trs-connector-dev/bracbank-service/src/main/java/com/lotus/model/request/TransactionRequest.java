package com.lotus.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionRequest {
    private String tranNo;

    private Long tranInfoSl;

    private String trMode;

    private String purose;

    private Float remAmountSource;

    private Float remAmountDest;

    private Float incentiveAmount;

    private Float incentiveAmountAgr;

    private Float rateValue;

    private Long remId;

    private String remFname;

    private String remLname;

    private String remTel;

    private String remAddress1;

    private String remCountry;

    private Long beneficiAryId;

    private String beneName;

    private String beneMname;

    private String beneLname;

    private String beneAccountNo;

    private String beneTel;

    private String branchCode;

    private String beneftnCode;

    private String beneAddress;

    private String beneCountry;

    private String exCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DDTHH:MM:SSTZD")
    private Date enteredDatetime;

    private String signaturevalue;

    private String countTr;

    private Long tranStatus;

    public TransactionRequest(String tranNo, Long tranInfoSl, String trMode, String purose, Float remAmountSource, Float remAmountDest, Float incentiveAmount, Float incentiveAmountAgr, Float rateValue, Long remId, String remFname, String remLname, String remTel, String remAddress1, String remCountry, Long beneficiAryId, String beneName, String beneMname, String beneLname, String beneAccountNo, String beneTel, String branchCode, String beneftnCode, String beneAddress, String beneCountry, String exCode, Date enteredDatetime, String signaturevalue, String countTr, Long tranStatus) {
        this.tranNo = tranNo;
        this.tranInfoSl = tranInfoSl;
        this.trMode = trMode;
        this.purose = purose;
        this.remAmountSource = remAmountSource;
        this.remAmountDest = remAmountDest;
        this.incentiveAmount = incentiveAmount;
        this.incentiveAmountAgr = incentiveAmountAgr;
        this.rateValue = rateValue;
        this.remId = remId;
        this.remFname = remFname;
        this.remLname = remLname;
        this.remTel = remTel;
        this.remAddress1 = remAddress1;
        this.remCountry = remCountry;
        this.beneficiAryId = beneficiAryId;
        this.beneName = beneName;
        this.beneMname = beneMname;
        this.beneLname = beneLname;
        this.beneAccountNo = beneAccountNo;
        this.beneTel = beneTel;
        this.branchCode = branchCode;
        this.beneftnCode = beneftnCode;
        this.beneAddress = beneAddress;
        this.beneCountry = beneCountry;
        this.exCode = exCode;
        this.enteredDatetime = enteredDatetime;
        this.signaturevalue = signaturevalue;
        this.countTr = countTr;
        this.tranStatus = tranStatus;
    }

    public String getTranNo() {
        return tranNo;
    }

    public void setTranNo(String tranNo) {
        this.tranNo = tranNo;
    }

    public Long getTranInfoSl() {
        return tranInfoSl;
    }

    public void setTranInfoSl(Long tranInfoSl) {
        this.tranInfoSl = tranInfoSl;
    }

    public String getTrMode() {
        return trMode;
    }

    public void setTrMode(String trMode) {
        this.trMode = trMode;
    }

    public String getPurose() {
        return purose;
    }

    public void setPurose(String purose) {
        this.purose = purose;
    }

    public Float getRemAmountSource() {
        return remAmountSource;
    }

    public void setRemAmountSource(Float remAmountSource) {
        this.remAmountSource = remAmountSource;
    }

    public Float getRemAmountDest() {
        return remAmountDest;
    }

    public void setRemAmountDest(Float remAmountDest) {
        this.remAmountDest = remAmountDest;
    }

    public Float getIncentiveAmount() {
        return incentiveAmount;
    }

    public void setIncentiveAmount(Float incentiveAmount) {
        this.incentiveAmount = incentiveAmount;
    }

    public Float getIncentiveAmountAgr() {
        return incentiveAmountAgr;
    }

    public void setIncentiveAmountAgr(Float incentiveAmountAgr) {
        this.incentiveAmountAgr = incentiveAmountAgr;
    }

    public Float getRateValue() {
        return rateValue;
    }

    public void setRateValue(Float rateValue) {
        this.rateValue = rateValue;
    }

    public Long getRemId() {
        return remId;
    }

    public void setRemId(Long remId) {
        this.remId = remId;
    }

    public String getRemFname() {
        return remFname;
    }

    public void setRemFname(String remFname) {
        this.remFname = remFname;
    }

    public String getRemLname() {
        return remLname;
    }

    public void setRemLname(String remLname) {
        this.remLname = remLname;
    }

    public String getRemTel() {
        return remTel;
    }

    public void setRemTel(String remTel) {
        this.remTel = remTel;
    }

    public String getRemAddress1() {
        return remAddress1;
    }

    public void setRemAddress1(String remAddress1) {
        this.remAddress1 = remAddress1;
    }

    public String getRemCountry() {
        return remCountry;
    }

    public void setRemCountry(String remCountry) {
        this.remCountry = remCountry;
    }

    public Long getBeneficiAryId() {
        return beneficiAryId;
    }

    public void setBeneficiAryId(Long beneficiAryId) {
        this.beneficiAryId = beneficiAryId;
    }

    public String getBeneName() {
        return beneName;
    }

    public void setBeneName(String beneName) {
        this.beneName = beneName;
    }

    public String getBeneMname() {
        return beneMname;
    }

    public void setBeneMname(String beneMname) {
        this.beneMname = beneMname;
    }

    public String getBeneLname() {
        return beneLname;
    }

    public void setBeneLname(String beneLname) {
        this.beneLname = beneLname;
    }

    public String getBeneAccountNo() {
        return beneAccountNo;
    }

    public void setBeneAccountNo(String beneAccountNo) {
        this.beneAccountNo = beneAccountNo;
    }

    public String getBeneTel() {
        return beneTel;
    }

    public void setBeneTel(String beneTel) {
        this.beneTel = beneTel;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBeneftnCode() {
        return beneftnCode;
    }

    public void setBeneftnCode(String beneftnCode) {
        this.beneftnCode = beneftnCode;
    }

    public String getBeneAddress() {
        return beneAddress;
    }

    public void setBeneAddress(String beneAddress) {
        this.beneAddress = beneAddress;
    }

    public String getBeneCountry() {
        return beneCountry;
    }

    public void setBeneCountry(String beneCountry) {
        this.beneCountry = beneCountry;
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

    public String getSignaturevalue() {
        return signaturevalue;
    }

    public void setSignaturevalue(String signaturevalue) {
        this.signaturevalue = signaturevalue;
    }

    public String getCountTr() {
        return countTr;
    }

    public void setCountTr(String countTr) {
        this.countTr = countTr;
    }

    public Long getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(Long tranStatus) {
        this.tranStatus = tranStatus;
    }
}
