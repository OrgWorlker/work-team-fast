package com.wtf.event.infrastructure.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Setter
@Getter
@ToString
public class IntegralLog {

    private Long id;
    private double count;
    private int userId;
    private Date crtTime;
}
