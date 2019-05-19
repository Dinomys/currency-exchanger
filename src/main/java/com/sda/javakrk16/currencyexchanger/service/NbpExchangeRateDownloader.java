package com.sda.javakrk16.currencyexchanger.service;

import com.sda.javakrk16.currencyexchanger.model.NbpExchangeRateResult;
import com.sda.javakrk16.currencyexchanger.model.NbpExchangeSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class NbpExchangeRateDownloader {
    RestTemplate restTemplate;

    @Autowired
    public NbpExchangeRateDownloader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NbpExchangeRateResult download(LocalDate date){
        Map<String, String> params = new HashMap<String, String>();
        params.put("table", "A");
        params.put("currency", "eur");
        params.put("date", date.toString());
        NbpExchangeSeries series = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/{table}/{currency}/{date}", NbpExchangeSeries.class, params);
        try {
            System.out.println(series.getCurrency() + " " + series.getRates().get(0).getMid());
            return new NbpExchangeRateResult(true, null, series.getRates().get(0).getMid());
        } catch (Exception e){
            return new NbpExchangeRateResult(false, e.getMessage(), null);
        }
        }
}
