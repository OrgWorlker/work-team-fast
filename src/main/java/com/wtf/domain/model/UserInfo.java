package com.wtf.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type User info.
 */
@Getter
@Setter
public class UserInfo extends BaseModel {

    private String realName;

    private String cid;

    private String cidImg1;

    private String cidImg2;

    private String birthDay;

    private Integer sex;

    private String telphone;

    private String city;

    private Integer cidFlag;
}
