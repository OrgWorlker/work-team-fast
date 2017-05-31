package com.wtf.core.domain.model;


import lombok.Getter;
import lombok.Setter;

/**
 * The type Tb user.
 */
@Setter
@Getter
public class TbUser extends BaseModel {
    private String tbUserNum;
    private Integer sex;
    private Integer age;
    private Integer level;
    private String tag;
    private String orderCode;
    private String buyName;
    private String buyNum;
    private Long cityId;
    private String address;
    private String imgUrl;
    private Long userId;

}
