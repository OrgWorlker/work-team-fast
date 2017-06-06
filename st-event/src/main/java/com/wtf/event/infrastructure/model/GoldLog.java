package com.wtf.event.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class GoldLog {
    private Long id;
    private double count;
    private int userId;
    private Date crtTime;
}
