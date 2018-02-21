package com.bertzzie.tiket.lib.interceptors;

import com.bertzzie.tiket.lib.models.base.OutputType;
import com.bertzzie.tiket.lib.properties.TiketProperties;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

/**
 * @author Alex Xandra Albert Sim
 */
public class MandatoryParamsInterceptor implements RequestInterceptor {
    @Autowired
    private TiketProperties properties;

    private final String FORMAT = "twh:%s;%s;";
    private final String OUTPUT = "output";

    @Override
    public void apply(RequestTemplate template) {
        String userAgent = String.format(FORMAT, properties.getBusinessId(), properties.getBusinessName());

        template.header(HttpHeaders.USER_AGENT, userAgent);
        template.query(OUTPUT, OutputType.JSON.getValue());
    }
}
