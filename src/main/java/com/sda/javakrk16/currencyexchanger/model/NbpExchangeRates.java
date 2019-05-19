package com.sda.javakrk16.currencyexchanger.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class NbpExchangeRates {
  String no;
  LocalDate effectiveDate;
  BigDecimal mid;
}
