package com.bertzzie.tiket.lib.models;

import com.bertzzie.tiket.lib.models.base.TiketBaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Alex Xandra Albert Sim
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListCurrencyResponse extends TiketBaseResponse {

    private List<CurrencyInfo> result;

    private Boolean loginStatus;

    private String token;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CurrencyInfo {
        private String id;

        private String lang;

        private String code;

        private String name;
    }
}
