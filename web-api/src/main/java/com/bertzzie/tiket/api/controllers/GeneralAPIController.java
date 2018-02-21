package com.bertzzie.tiket.api.controllers;

import com.bertzzie.tiket.api.models.Currency;
import com.bertzzie.tiket.api.models.Language;
import com.bertzzie.tiket.lib.clients.GeneralAPI;
import com.bertzzie.tiket.lib.clients.GetToken;
import com.bertzzie.tiket.lib.models.ListCurrencyResponse;
import com.bertzzie.tiket.lib.models.ListLanguageResponse;
import com.bertzzie.tiket.lib.properties.TiketProperties;
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
public class GeneralAPIController {

    @Autowired
    private GetToken tokenFeign;

    @Autowired
    private GeneralAPI generalAPIFeign;

    @Autowired
    private TiketProperties properties;

    public static final String GET_LANGUAGES_PATH = "/languages";
    public static final String GET_CURRENCIES_PATH = "/currencies";

    @RequestMapping(
            name = "Get list of supported language",
            path = GET_LANGUAGES_PATH,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Language> getLanguages() {
        String token = tokenFeign.execute(properties.getSecret()).getToken();
        ListLanguageResponse languages = generalAPIFeign.listLanguage(token);

        List<Language> result = languages.getResult().stream().map(info ->
                Language.builder().code(info.getCode()).name(info.getNameLong()).build()
        ).collect(Collectors.toList());

        return result;
    }

    @RequestMapping(
            name = "Get list of supported currencies",
            path = GET_CURRENCIES_PATH,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Currency> getCurrencies() {
        String token = tokenFeign.execute(properties.getSecret()).getToken();
        ListCurrencyResponse currencies = generalAPIFeign.listCurrency(token);

        List<Currency> result = currencies.getResult().stream().map(info ->
                Currency.builder().code(info.getCode()).language(info.getLang()).name(info.getName()).build()
        )
                .filter(curr -> curr.getCode().equals("IDR") || curr.getCode().equals("USD"))
                .collect(Collectors.toList());

        return result;
    }
}
