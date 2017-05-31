package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * The interface Tb user mapper.
 */
@Mapper
public interface ITbUserMapper extends BaseMapper<TbUser> {

    /**
     * Find tb user num by user id list.
     *
     * @param userId the user id
     * @return the list
     * @throws Exception the exception
     */
    List<TbUser> findTbUserNumByUserId(Long userId) throws Exception;
}
