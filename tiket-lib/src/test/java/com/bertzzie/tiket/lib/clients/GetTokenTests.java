package com.bertzzie.tiket.lib.clients;

import com.bertzzie.tiket.lib.models.GetTokenResponse;
import com.bertzzie.tiket.lib.models.base.OutputType;
import com.bertzzie.tiket.lib.properties.TiketProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Alex Xandra Albert Sim
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GetTokenTests {

    @Autowired
    private GetToken feign;

    @Autowired
    private TiketProperties properties;

    @Test
    public void test() {
        String secret = properties.getSecret();

        GetTokenResponse response = feign.execute(secret);

        assertEquals(OutputType.JSON, response.getOutputType());
        assertFalse(response.getLoginStatus());
        assertNotNull(response.getToken());
    }
}
