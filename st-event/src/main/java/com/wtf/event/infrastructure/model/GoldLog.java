package com.wtf.event.infrastructure.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class GoldLog {

    private Long id;
    private Double count;
    private Long userId;
    private Date crtTime;
}
