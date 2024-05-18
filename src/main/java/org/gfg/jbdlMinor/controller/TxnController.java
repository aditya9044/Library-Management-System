package org.gfg.jbdlMinor.controller;

import jakarta.validation.Valid;
import org.gfg.jbdlMinor.exception.TxnException;
import org.gfg.jbdlMinor.request.TxnCreateRequest;
import org.gfg.jbdlMinor.request.TxnReturnRequest;
import org.gfg.jbdlMinor.response.GenericResponse;
import org.gfg.jbdlMinor.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;

    @PostMapping("/create")
    private ResponseEntity<GenericResponse<String>> createTxn(@RequestBody @Valid TxnCreateRequest txnCreateRequest) throws TxnException {
        String txnId = txnService.create(txnCreateRequest);
        GenericResponse<String> response  = new GenericResponse<>(txnId,"success","","200");
        ResponseEntity entity = new ResponseEntity<>(response, HttpStatus.OK);
        return entity;
    }

    @PutMapping("/return")
    private int returnTxn(@RequestBody TxnReturnRequest txnReturnRequest) throws TxnException {
        return txnService.returnBook(txnReturnRequest);
    }
}
