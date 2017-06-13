package com.wtf.core.domain.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Base model.
 * 基础模型类
 */
@Setter
@Getter
@JsonIgnoreProperties({"handler"})
public class BaseModel implements Serializable {

    private Long id;

    private Date updTime;

    private Date crtTime;

    @Override
    public String toString() {
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        return JSON.toJSONString(this, SerializerFeature.WriteDateUseDateFormat);
    }
}
