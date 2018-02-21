package com.bertzzie.tiket;

import com.bertzzie.tiket.lib.properties.TiketFeignProperties;
import com.bertzzie.tiket.lib.properties.TiketProperties;
import com.bertzzie.tiket.properties.TiketAPIClientProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableFeignClients
@EnableConfigurationProperties({
        TiketProperties.class,
        TiketFeignProperties.class,
        TiketAPIClientProperties.class
})
public class TiketApplicationTests {

    @Test
    public void contextLoads() {
    }

}
