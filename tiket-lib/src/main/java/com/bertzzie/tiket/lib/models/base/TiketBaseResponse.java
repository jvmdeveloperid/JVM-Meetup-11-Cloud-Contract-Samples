package com.bertzzie.tiket.lib.models.base;

import lombok.Data;

/**
 * @author Alex Xandra Albert Sim
 */
@Data
public abstract class TiketBaseResponse {
    private Diagnostic diagnostic;

    private OutputType outputType;
}
