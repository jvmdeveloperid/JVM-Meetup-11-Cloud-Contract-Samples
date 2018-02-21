package com.bertzzie.tiket.lib.clients;

import com.bertzzie.tiket.lib.configurations.TiketConfiguration;
import com.bertzzie.tiket.lib.models.ListCurrencyResponse;
import com.bertzzie.tiket.lib.models.ListLanguageResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Alex Xandra Albert Sim
 */
@FeignClient(
        name = "generalAPIFeign",
        url = "${com.tiket.urls.base}",
        configuration = TiketConfiguration.class
)
public interface GeneralAPI {
    @RequestMapping(
            name = "Get list of currency for tiket.com",
            value = "${com.tiket.urls.list-currency}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ListCurrencyResponse listCurrency(@RequestParam("token") String token);

    @RequestMapping(
            name = "Get list of language for tiket.com",
            value = "${com.tiket.urls.list-language}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ListLanguageResponse listLanguage(@RequestParam("token") String token);
}
