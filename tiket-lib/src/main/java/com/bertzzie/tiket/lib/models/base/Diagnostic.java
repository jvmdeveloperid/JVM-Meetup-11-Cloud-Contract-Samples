package com.bertzzie.tiket.lib.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Alex Xandra Albert Sim
 */
@Data
public class Diagnostic {

    private Integer status;

    @JsonProperty("elapsetime")
    private Float elapsedTime;

    @JsonProperty("memoryusage")
    private String memoryUsage;

    private Long unixTimestamp;

    private String confirm;

    private String lang;

    private String currency;
}
