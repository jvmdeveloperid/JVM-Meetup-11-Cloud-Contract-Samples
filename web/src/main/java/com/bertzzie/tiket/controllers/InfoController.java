package com.bertzzie.tiket.controllers;

import com.bertzzie.tiket.api.models.Currency;
import com.bertzzie.tiket.api.models.Language;
import com.bertzzie.tiket.clients.TiketAPIClient;
import com.bertzzie.tiket.models.InfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * [Documentation Here]
 *
 * @author Alex Xandra Albert Sim
 */
@RestController
public class InfoController {
    @Autowired
    private TiketAPIClient clientFeign;

    @RequestMapping(
            name = "Get list of supported currencies",
            path = "/info",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<InfoResponse> info() {
        List<Currency> currencies = clientFeign.getCurrencies();
        List<Language> languages = clientFeign.getLanguages();

        return languages.stream()
                .map(lang -> {
                    String currency = currencies.stream()
                            .filter(c -> c.getLanguage().contains(lang.getCode()))
                            .findFirst()
                            .map(Currency::getCode)
                            .orElse("");

                    return InfoResponse.builder()
                            .currencyCode(currency)
                            .languageCode(lang.getCode())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
