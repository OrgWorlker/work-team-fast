package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.IntegralLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * The interface Gold log mapper.
 */
@Mapper
public interface IIntegralLogMapper extends BaseMapper<IntegralLog> {
    /**
     * Find by user id and type list.
     *
     * @param userId the user id
     * @return the list
     * @throws Exception the exception
     */
    List<IntegralLog> findByUserId(Long userId) throws Exception ;
}
