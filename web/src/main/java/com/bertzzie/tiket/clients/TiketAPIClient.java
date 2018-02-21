package com.bertzzie.tiket.clients;

import com.bertzzie.tiket.api.models.Currency;
import com.bertzzie.tiket.api.models.Language;
import com.bertzzie.tiket.configs.TiketAPIClientConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * [Documentation Here]
 *
 * @author Alex Xandra Albert Sim
 */
@FeignClient(
        name = "tiketAPIClient",
        url = "${service.tiket.endpoint}",
        configuration = TiketAPIClientConfiguration.class
)
public interface TiketAPIClient {
    @RequestMapping(
            name = "Get list of supported language",
            path = "/languages",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<Language> getLanguages();

    @RequestMapping(
            name = "Get list of supported currencies",
            path = "/currencies",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<Currency> getCurrencies();
}
