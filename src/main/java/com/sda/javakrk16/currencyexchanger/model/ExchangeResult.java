package com.sda.javakrk16.currencyexchanger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ExchangeResult {
    private BigDecimal euro;
    private String errorMessage;
}
