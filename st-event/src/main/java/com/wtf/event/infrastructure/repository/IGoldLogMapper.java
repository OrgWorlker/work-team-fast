package com.wtf.event.infrastructure.repository;

import com.wtf.event.infrastructure.model.GoldLog;
import org.apache.ibatis.annotations.Mapper;


/**
 * The interface Gold log mapper.
 */
@Mapper
public interface IGoldLogMapper {

    /**
     * Insert int.
     *
     * @param log the log
     * @return the int
     * @throws Exception the exception
     */
    int insert(GoldLog log) throws Exception;
}
