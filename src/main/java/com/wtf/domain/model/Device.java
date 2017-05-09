package com.wtf.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Device extends BaseModel {
    private String name;
    private String code;
    private Long userId;
}
