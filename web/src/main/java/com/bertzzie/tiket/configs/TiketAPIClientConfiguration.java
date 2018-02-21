package com.bertzzie.tiket.configs;

import com.bertzzie.tiket.properties.TiketAPIClientProperties;
import feign.Logger;
import feign.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Documentation Here]
 *
 * @author Alex Xandra Albert Sim
 */
@Configuration
public class TiketAPIClientConfiguration {
    @Autowired
    private TiketAPIClientProperties properties;

    @Bean
    public Request.Options options() {
        return new Request.Options(
                (int) properties.getTimeUnit().toMillis(properties.getConnectTimeout()),
                (int) properties.getTimeUnit().toMillis(properties.getReadTimeout())
        );
    }

    @Bean
    public Logger.Level logLevel() {
        return properties.getLevel();
    }
}
