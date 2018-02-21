package com.bertzzie.tiket.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * [Documentation Here]
 *
 * @author Alex Xandra Albert Sim
 */
@DirtiesContext
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.bertzzie:web-api:+:stubs:8080")
public class InfoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InfoController infoController;

    @Test
    public void testInfo() throws Exception {
        final String RESULT = "[{\"languageCode\": \"en\", \"currencyCode\": \"USD\"},{\"languageCode\": \"id\", \"currencyCode\": \"IDR\"}]";

        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/info")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(RESULT, false));
    }
}
