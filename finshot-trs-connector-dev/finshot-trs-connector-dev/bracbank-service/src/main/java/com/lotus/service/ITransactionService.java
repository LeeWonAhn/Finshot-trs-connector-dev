package com.lotus.service;

import com.lotus.entity.InformationTransaction;
import com.lotus.model.request.BaseRequest;
import com.lotus.model.request.TransOrder;

import java.io.IOException;
import java.util.List;

public interface ITransactionService {
    InformationTransaction addTransactionInfo(TransOrder InformationTransaction) throws IOException;
    BaseRequest checkStatus(TransOrder transOrder) throws IOException;
    List<InformationTransaction> search();

    BaseRequest validateAccount(TransOrder transOrder) throws IOException;
    BaseRequest validateMremit(TransOrder transOrder) throws IOException;
    BaseRequest send(TransOrder transOrder) throws IOException;
}
