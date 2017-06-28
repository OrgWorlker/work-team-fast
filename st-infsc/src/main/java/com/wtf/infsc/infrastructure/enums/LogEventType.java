package com.wtf.infsc.infrastructure.enums;


import lombok.Getter;
import lombok.Setter;

/**
 * The enum Log event type.
 */
public enum LogEventType {
    /**
     * Gold log event type.
     */
    GOLD("G"),
    /**
     * Integral log event type.
     */
    INTEGRAL("I");

    @Setter
    @Getter
    private String type;

    private LogEventType(String type) {
        this.type = type;
    }
}
