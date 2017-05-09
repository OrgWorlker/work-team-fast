package com.wtf.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * The type Goods.
 */
@Setter
@Getter
public class Goods extends BaseModel {
    private String name;
    private String url;
    private String imgUrl1;
    private String imgUrl2;
    private Integer buyCount;
    private Double buyPrice;
    private Double showPrice;
    private String size;
}
