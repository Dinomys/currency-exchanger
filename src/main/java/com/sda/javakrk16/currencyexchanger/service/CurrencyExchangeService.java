package com.sda.javakrk16.currencyexchanger.service;

import com.sda.javakrk16.currencyexchanger.model.ExchangeResult;
import com.sda.javakrk16.currencyexchanger.model.NbpExchangeRateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Component
public class CurrencyExchangeService implements ICurrencyExchangeService {

    NbpExchangeRateDownloader nbpExchangeRateDownloader;

    @Autowired
    public CurrencyExchangeService(NbpExchangeRateDownloader nbpExchangeRateDownloader) {
        this.nbpExchangeRateDownloader = nbpExchangeRateDownloader;
    }

    @Override
    public ExchangeResult calculate(BigDecimal pln, LocalDate exchangeDate) {
        NbpExchangeRateResult result = nbpExchangeRateDownloader.download(exchangeDate);
        if (result.isStatus()) {
            try {
                return new ExchangeResult(pln.divide(result.getExchangeRate(), 2, RoundingMode.HALF_DOWN), null);
            } catch (Exception e){
                return new ExchangeResult(pln, e.getMessage());
            }
        } else {
            return new ExchangeResult(pln, result.getErrorMessage());
        }
    }
}
