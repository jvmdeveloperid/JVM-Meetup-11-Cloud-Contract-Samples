package com.bertzzie.tiket.lib.clients;

import com.bertzzie.tiket.lib.configurations.TiketConfiguration;
import com.bertzzie.tiket.lib.models.GetTokenResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Alex Xandra Albert Sim
 */
@FeignClient(
        name = "getTokenFeign",
        url = "${com.tiket.urls.base}",
        configuration = TiketConfiguration.class
)
public interface GetToken {
    @RequestMapping(
            name = "Get Token for tiket.com Request",
            value = "${com.tiket.urls.get-token}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    GetTokenResponse execute(@RequestParam("secretkey") String secretKey);
}
