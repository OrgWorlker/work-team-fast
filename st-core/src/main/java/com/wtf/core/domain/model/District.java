package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The type District.
 */
@Setter
@Getter
public class District extends BaseModel {

    /**
     * The Name.
     */
    private String name;

    /**
     * The Pid.
     */
    private Long pid;

    /**
     * The Level.
     */
    private Integer level;
}
