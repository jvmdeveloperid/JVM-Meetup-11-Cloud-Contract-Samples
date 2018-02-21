package com.bertzzie.tiket;

import com.bertzzie.tiket.lib.properties.TiketFeignProperties;
import com.bertzzie.tiket.lib.properties.TiketProperties;
import com.bertzzie.tiket.properties.TiketAPIClientProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableConfigurationProperties({
        TiketProperties.class,
        TiketFeignProperties.class,
        TiketAPIClientProperties.class
})
@SpringBootApplication
public class TiketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiketApplication.class, args);
    }
}
