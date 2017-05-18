package com.wtf.core.domain.model;


import lombok.Getter;
import lombok.Setter;

/**
 * The type Users.
 */
@Setter
@Getter
public class User extends BaseModel {

    private String name;

    private String loginName;

    private String loginPwd;

    private Integer comeFrom;

    private String tradePwd;

    private UserInfo userInfo;

    private UserLevel userLevel;

    private Payment payment;
}
