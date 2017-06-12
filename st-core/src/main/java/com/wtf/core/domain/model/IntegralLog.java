package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class IntegralLog extends BaseModel {

    private double count;
    private int userId;
}
