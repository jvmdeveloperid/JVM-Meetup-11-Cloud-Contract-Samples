package com.bertzzie.tiket.properties;

import feign.Logger;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

/**
 * [Documentation Here]
 *
 * @author Alex Xandra Albert Sim
 */
@Data
@ConfigurationProperties("feign.api")
public class TiketAPIClientProperties {

    private Long connectTimeout = 20000L;

    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;

    private Long readTimeout = 20000L;

    private Logger.Level level = Logger.Level.BASIC;
}
