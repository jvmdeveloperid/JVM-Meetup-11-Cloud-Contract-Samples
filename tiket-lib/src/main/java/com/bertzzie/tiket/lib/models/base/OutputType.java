package com.bertzzie.tiket.lib.models.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Alex Xandra Albert Sim
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OutputType {
    JSON("json"),
    XML("xml"),
    SERIALIZED("serialized"),
    ARRAY("array");

    @JsonProperty("output_type")
    private final String value;

    OutputType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static OutputType fromValue(final JsonNode node) {
        for (OutputType type : OutputType.values()) {
            if (type.getValue().equalsIgnoreCase(node.asText())) {
                return type;
            }
        }

        return null;
    }
}
