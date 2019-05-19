package com.sda.javakrk16.currencyexchanger.service;

import com.sda.javakrk16.currencyexchanger.model.ExchangeResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ICurrencyExchangeService {

    ExchangeResult calculate(BigDecimal pln, LocalDate exchangeDate);
}
