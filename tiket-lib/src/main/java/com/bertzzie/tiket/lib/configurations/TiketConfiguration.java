package com.bertzzie.tiket.lib.configurations;

import com.bertzzie.tiket.lib.interceptors.MandatoryParamsInterceptor;
import com.bertzzie.tiket.lib.properties.TiketFeignProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @author Alex Xandra Albert Sim
 */
@Configuration
public class TiketConfiguration {

    @Autowired
    private TiketFeignProperties properties;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new MandatoryParamsInterceptor();
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(
                (int) properties.getTimeUnit().toMillis(properties.getConnectTimeout()),
                (int) properties.getTimeUnit().toMillis(properties.getReadTimeout())
        );
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return properties.getLevel();
    }

    @Bean
    public Decoder decoder() {
        HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(tiketObjectMapper());
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(converter);

        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    private ObjectMapper tiketObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        return mapper;
    }
}
