package com.bertzzie.tiket.api;

import com.bertzzie.tiket.lib.properties.TiketFeignProperties;
import com.bertzzie.tiket.lib.properties.TiketProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * [Documentation Here]
 *
 * @author Alex Xandra Albert Sim
 */
@SpringBootApplication
@EnableFeignClients(
        basePackages = {"com.bertzzie.tiket.lib.clients"}
)
@EnableConfigurationProperties({
        TiketProperties.class,
        TiketFeignProperties.class
})
public class TiketAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(TiketAPIApplication.class, args);
    }
}
