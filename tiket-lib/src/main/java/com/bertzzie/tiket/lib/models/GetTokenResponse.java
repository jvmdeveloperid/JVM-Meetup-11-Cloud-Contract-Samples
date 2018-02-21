package com.bertzzie.tiket.lib.models;

import com.bertzzie.tiket.lib.models.base.TiketBaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alex Xandra Albert Sim
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetTokenResponse extends TiketBaseResponse {

    private Boolean loginStatus;

    private String token;
}
