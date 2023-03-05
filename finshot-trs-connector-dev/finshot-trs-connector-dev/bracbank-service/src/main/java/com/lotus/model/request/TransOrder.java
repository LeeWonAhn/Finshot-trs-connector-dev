package com.lotus.model.request;

import lombok.Data;

public class TransOrder {
    private BaseRequest baseReq;

    private TransactionRequest transactionReq;

    private SignatureRequest signatureReq;

    public TransOrder(BaseRequest baseReq, TransactionRequest transactionReq, SignatureRequest signatureReq) {
        this.baseReq = baseReq;
        this.transactionReq = transactionReq;
        this.signatureReq = signatureReq;
    }

    public BaseRequest getBaseReq() {
        return baseReq;
    }

    public void setBaseReq(BaseRequest baseReq) {
        this.baseReq = baseReq;
    }

    public TransactionRequest getTransactionReq() {
        return transactionReq;
    }

    public void setTransactionReq(TransactionRequest transactionReq) {
        this.transactionReq = transactionReq;
    }

    public SignatureRequest getSignatureReq() {
        return signatureReq;
    }

    public void setSignatureReq(SignatureRequest signatureReq) {
        this.signatureReq = signatureReq;
    }
}
