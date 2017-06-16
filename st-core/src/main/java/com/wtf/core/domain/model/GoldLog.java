package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GoldLog extends BaseModel {
    private double count;
    private int userId;
}
