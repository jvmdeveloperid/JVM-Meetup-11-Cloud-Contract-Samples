package com.bertzzie.tiket.tests;

import com.bertzzie.tiket.api.controllers.GeneralAPIController;
import com.bertzzie.tiket.lib.clients.GeneralAPI;
import com.bertzzie.tiket.lib.clients.GetToken;
import com.bertzzie.tiket.lib.models.GetTokenResponse;
import com.bertzzie.tiket.lib.models.ListCurrencyResponse;
import com.bertzzie.tiket.lib.models.ListCurrencyResponse.CurrencyInfo;
import com.bertzzie.tiket.lib.models.ListLanguageResponse;
import com.bertzzie.tiket.lib.models.ListLanguageResponse.LanguageInfo;
import com.bertzzie.tiket.lib.properties.TiketProperties;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * [Documentation Here]
 *
 * @author Alex Xandra Albert Sim
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class TiketTestsBase {
    @Mock
    private GeneralAPI generalAPIFeign;

    @Mock
    private GetToken getTokenFeign;

    @Mock
    private TiketProperties properties;

    @InjectMocks
    private GeneralAPIController controller;

    private final String SECRET_KEY = "SECRET";
    private final String TOKEN = "TOKEN";

    @Before
    public void setup() {
        when(properties.getSecret()).thenReturn(SECRET_KEY);
        when(getTokenFeign.execute(eq(SECRET_KEY))).thenReturn(mockGetTokenResponse());
        when(generalAPIFeign.listLanguage(eq(TOKEN))).thenReturn(mockListLanguageResponse());
        when(generalAPIFeign.listCurrency(eq(TOKEN))).thenReturn(mockListCurrencyResponse());

        RestAssuredMockMvc.standaloneSetup(controller);
    }

    private ListCurrencyResponse mockListCurrencyResponse() {
        List<CurrencyInfo> currencies = new ArrayList<>();
        currencies.add(CurrencyInfo.builder().code("IDR").lang("id").name("IDR - Rupiah Indonesia").build());
        currencies.add(CurrencyInfo.builder().code("USD").lang("en-us").name("USD - Dolar Amerika").build());
        currencies.add(CurrencyInfo.builder().code("EUR").lang("en").name("EUR - Euro").build());

        return ListCurrencyResponse.builder()
                .result(currencies)
                .build();
    }

    private ListLanguageResponse mockListLanguageResponse() {
        List<LanguageInfo> languages = new ArrayList<>();
        languages.add(LanguageInfo.builder().code("id").nameLong("Indonesian").build());
        languages.add(LanguageInfo.builder().code("en").nameLong("English").build());

        return ListLanguageResponse.builder()
                .result(languages)
                .build();
    }

    private GetTokenResponse mockGetTokenResponse() {
        return GetTokenResponse.builder()
                .token(TOKEN)
                .build();
    }
}
