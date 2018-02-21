package com.bertzzie.tiket.lib.clients;

import com.bertzzie.tiket.lib.models.ListCurrencyResponse;
import com.bertzzie.tiket.lib.models.ListLanguageResponse;
import com.bertzzie.tiket.lib.models.base.OutputType;
import com.bertzzie.tiket.lib.properties.TiketProperties;
import org.junit.Before;
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
public class GeneralAPITests {

    @Autowired
    private TiketProperties properties;

    @Autowired
    private GetToken getTokenFeign;

    @Autowired
    private GeneralAPI generalAPIFeign;

    private String token = "";

    @Before
    public void setup() {
        token = getTokenFeign.execute(properties.getSecret()).getToken();
    }

    @Test
    public void testListCurrency() {
        ListCurrencyResponse response = generalAPIFeign.listCurrency(token);

        assertEquals(OutputType.JSON, response.getOutputType());
        assertTrue(response.getResult().size() > 0);
        assertEquals(token, response.getToken());
        assertFalse(response.getLoginStatus());
    }

    @Test
    public void testListLanguage() {
        ListLanguageResponse response = generalAPIFeign.listLanguage(token);

        assertEquals(OutputType.JSON, response.getOutputType());
        assertEquals(2, response.getResult().size());
        assertEquals(token, response.getToken());
        assertFalse(response.getLoginStatus());
    }
}
