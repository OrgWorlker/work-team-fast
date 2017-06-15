package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.TakeLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Take log mapper.
 */
@Mapper
public interface ITakeLogMapper  extends BaseMapper<TakeLog> {

    /**
     * Find by user id and type list.
     *
     * @param userId the user id
     * @param type   the type
     * @return the list
     * @throws Exception the exception
     */
    List<TakeLog> findByUserIdAndType(@Param("userId") Long userId, @Param("type") String type) throws Exception;
}
