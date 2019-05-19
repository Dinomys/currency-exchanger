package com.sda.javakrk16.currencyexchanger.controller;

import com.sda.javakrk16.currencyexchanger.model.ExchangeResult;
import com.sda.javakrk16.currencyexchanger.service.ICurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class ExchangeController {

    private ICurrencyExchangeService exchangeService;

    @Autowired
    public ExchangeController(ICurrencyExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/exchange/{pln}/{date}")
    public ResponseEntity<ExchangeResult> GetExchangeValues(@PathVariable(name = "pln") BigDecimal pln,
                                                            @PathVariable(name = "date")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exchangeDate) {
        ExchangeResult exchangeResult = exchangeService.calculate(pln, exchangeDate);
        return new ResponseEntity<>(exchangeResult, HttpStatus.OK);
    }
}
