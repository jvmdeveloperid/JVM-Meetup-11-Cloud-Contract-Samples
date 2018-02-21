package com.bertzzie.tiket.lib;

import com.bertzzie.tiket.lib.properties.TiketFeignProperties;
import com.bertzzie.tiket.lib.properties.TiketProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Alex Xandra Albert Sim
 */
@EnableFeignClients
@EnableConfigurationProperties({
        TiketFeignProperties.class,
        TiketProperties.class
})
@SpringBootApplication
public class TiketFeignTestsApplication {

}
