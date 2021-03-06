package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Task.
 */
@Setter
@Getter
public class Task extends BaseModel {

    private String name;
    private String shopUrl;
    private String consignor;
    private String shippingAddress;
    private String shippingArea;
    private String shippingCall;
    private User user;
}
