package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Device extends BaseModel {
    private String name;
    private String code;
    private Long userId;
}
