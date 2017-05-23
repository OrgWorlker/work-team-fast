package com.wtf.core.domain.model;

import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@Setter
@Getter
public class UserTask  extends BaseModel {

    //买手ID
    private Long buyerId;
    //任务ID
    private Long taskId;
    //接单时间
    private Date orderTime;
    //完成时间
    private Date finishTime;
    //发布时间
    private Date startTime;
    //截止时间
    private Date endTime;
    //完成状态
    private Integer status;


}
