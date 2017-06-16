package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.GoldLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * The interface Gold log mapper.
 */
@Mapper
public interface IGoldLogMapper extends BaseMapper<GoldLog> {


    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     * @throws Exception the exception
     */
    List<GoldLog> findByUserId(Long userId) throws Exception;
}
