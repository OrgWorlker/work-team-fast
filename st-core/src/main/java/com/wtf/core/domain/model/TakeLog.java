package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;


/**
 * The type Take log.
 */
@Setter
@Getter
public class TakeLog extends BaseModel {

    /**
     * The User id.
     */
    private Long userId;
    /**
     * The Count.
     */
    private Double count;
    /**
     * The Flag.
     */
    private int flag;
    /**
     * The Type.
     */
    private int type;

}
