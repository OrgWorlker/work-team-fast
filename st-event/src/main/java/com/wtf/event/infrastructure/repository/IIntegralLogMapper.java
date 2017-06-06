package com.wtf.event.infrastructure.repository;

import com.wtf.event.infrastructure.model.IntegralLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface Gold log mapper.
 */
@Mapper
public interface IIntegralLogMapper {

    /**
     * Insert int.
     *
     * @param log the log
     * @return the int
     * @throws Exception the exception
     */
    int insert(IntegralLog log) throws Exception;
}
