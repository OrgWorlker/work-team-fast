package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserBank extends BaseModel {

    /**
     * The Real name.
     */
    String realName;

    /**
     * The Card.
     */
    String card;

    /**
     * The Bank name.
     */
    String bankName;
    /**
     * The Bank city.
     */
    String bankCity;
    /**
     * The Bank detail name.
     */
    String bankDetailName;
    /**
     * The User id.
     */
    Long userId;

}
