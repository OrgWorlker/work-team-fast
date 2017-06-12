package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.IntegralLog;
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
