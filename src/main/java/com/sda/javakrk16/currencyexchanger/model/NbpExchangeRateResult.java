package com.sda.javakrk16.currencyexchanger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class NbpExchangeRateResult {
    private boolean status;
    private String errorMessage;
    private BigDecimal exchangeRate;
}
