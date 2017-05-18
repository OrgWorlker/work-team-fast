package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zc.lin on 2017/5/5.
 */
@Setter
@Getter
public class UserLevel extends BaseModel {

    private Integer vip;

    private Double gold;

    private Double usableGold;

    private Double integral;

    private Double usableIntegral;

}
