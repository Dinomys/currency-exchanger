package com.sda.javakrk16.currencyexchanger.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class NbpExchangeSeries {
char table;
String currency;
List<NbpExchangeRates> rates;
}
