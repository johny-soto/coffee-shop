package com.ceiba.order.adapter.repository;

import com.ceiba.order.port.repository.CurrencyRateRepository;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Repository
public class RestCurrencyRateRepository implements CurrencyRateRepository {
    private static final String URL_SERVICE = "https://free.currconv.com/api/v7/convert?q=";
    private static final String API_KEY = "11c4a8df987c6d9705ca";

    private final RestTemplate restTemplate;

    public RestCurrencyRateRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Double getTRM(String sourceCurrency, String targetCurrency) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);
        String response = restTemplate.exchange(String.format(
                        "%s%s_%s&compact=ultra&apiKey=%s",
                        URL_SERVICE,
                        sourceCurrency,
                        targetCurrency,
                        API_KEY),
                HttpMethod.GET,
                entity,
                String.class)
                .getBody();
        JSONObject json = new JSONObject(response);
        return json.getDouble(String.format("%s_%s", sourceCurrency, targetCurrency));
    }
}
