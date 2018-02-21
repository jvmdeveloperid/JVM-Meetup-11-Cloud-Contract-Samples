package com.bertzzie.tiket.lib.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Alex Xandra Albert Sim
 */
@Data
@ConfigurationProperties("com.tiket")
public class TiketProperties {

    private String secret;

    private String host;

    private String businessId;

    private String businessName;
}
