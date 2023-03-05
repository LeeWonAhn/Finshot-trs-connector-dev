package com.lotus.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@Entity
@Table(name = "brac_bank")
@XmlRootElement
public class InformationTransaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "ex_password")
    private String exPassword;

    @Column(name = "ex_code")
    private String exCode;

    @Column(name = "entered_datetime")
    private Date enteredDatetime;

    @Column(name = "tran_no")
    private String tranNo;

    @Column(name = "tran_infoSl")
    private Long tranInfoSl;

    @Column(name = "tr_mode")
    private String trMode;

    @Column(name = "purose")
    private String purose;

    @Column(name = "rem_amount_dest")
    private Float remAmountDest;

    @Column(name = "rem_amount_source")
    private Float remAmountSource;

    @Column(name = "incentive_amount")
    private Float incentiveAmount;

    @Column(name = "incentive_amount_agr")
    private Float incentiveAmountAgr;

    @Column(name = "rate_value")
    private Float rateValue;

    @Column(name = "rem_id")
    private Long remId;

    @Column(name = "rem_fname")
    private String remFname;

    @Column(name = "rem_lname")
    private String remLname;

    @Column(name = "rem_tel")
    private String remTel;

    @Column(name = "rem_address1")
    private String remAddress1;

    @Column(name = "rem_country")
    private String remCountry;

    @Column(name = "benefici_ary_id")
    private Long beneficiAryId;

    @Column( name = "bene_name")
    private String beneName;

    @Column(name = "bene_mname")
    private String beneMname;

    @Column(name = "bene_lname")
    private String beneLname;

    @Column(name = "bene_account_no")
    private String beneAccountNo;

    @Column( name = "bene_tel")
    private String beneTel;

    @Column(name = "branch_code")
    private String branchCode;

    @Column(name = "beneftn_code")
    private String beneftnCode;

    @Column(name = "bene_address")
    private String beneAddress;

    @Column(name = "bene_country")
    private String beneCountry;

    @Column(name = "count_tr")
    private String countTr;

    @Column(name = "tran_status")
    private Long tranStatus;

    @Column(name = "signature_value")
    private String signatureValue;

    public InformationTransaction(Long id, String userName, String exPassword, String exCode, Date enteredDatetime, String tranNo, Long tranInfoSl, String trMode, String purose, Float remAmountDest, Float remAmountSource, Float incentiveAmount, Float incentiveAmountAgr, Float rateValue, Long remId, String remFname, String remLname, String remTel, String remAddress1, String remCountry, Long beneficiAryId, String beneName, String beneMname, String beneLname, String beneAccountNo, String beneTel, String branchCode, String beneftnCode, String beneAddress, String beneCountry, String countTr, Long tranStatus, String signatureValue) {
        this.id = id;
        this.userName = userName;
        this.exPassword = exPassword;
        this.exCode = exCode;
        this.enteredDatetime = enteredDatetime;
        this.tranNo = tranNo;
        this.tranInfoSl = tranInfoSl;
        this.trMode = trMode;
        this.purose = purose;
        this.remAmountDest = remAmountDest;
        this.remAmountSource = remAmountSource;
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
        this.countTr = countTr;
        this.tranStatus = tranStatus;
        this.signatureValue = signatureValue;
    }

    public InformationTransaction() {
        
    }
}
