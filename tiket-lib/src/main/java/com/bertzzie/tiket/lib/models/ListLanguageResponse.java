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
public class ListLanguageResponse extends TiketBaseResponse {

    private List<LanguageInfo> result;

    private Boolean loginStatus;

    private String token;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LanguageInfo {
        private String code;

        private String nameLong;

        private String nameShort;
    }
}
