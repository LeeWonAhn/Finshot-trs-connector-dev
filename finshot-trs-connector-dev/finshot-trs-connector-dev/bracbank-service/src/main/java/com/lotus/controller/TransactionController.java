package com.lotus.controller;


import com.lotus.entity.InformationTransaction;
import com.lotus.service.ITransactionService;
import com.lotus.model.request.TransOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping (path = "/transaction")
@RestController
public class TransactionController {
    @Autowired
    private ITransactionService service;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<InformationTransaction> getAll() {
        return service.seach();
    }

    @PostMapping("/add")
    public InformationTransaction add(@RequestBody TransOrder transOrder) throws IOException {
        InformationTransaction info = service.addTransactionInfo(transOrder);
        return info;
    }

}
