package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Payment extends BaseModel {

    private String name;

    private String code;

    private String wechatNum;

    private String wechatQrcodeUrl;

    private String alipayNum;

    private String alipayQrcodeUrl;

    private String bankName;

    private String bankBranch;

    private String bankAccount;
}
