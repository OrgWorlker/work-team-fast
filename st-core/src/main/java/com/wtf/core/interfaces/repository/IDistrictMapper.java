package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.District;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * The interface District mapper.
 */
@Mapper
public interface IDistrictMapper extends BaseMapper<District> {

    /**
     * Find by pid list.
     *
     * @param pid the pid
     * @return the list
     * @throws Exception the exception
     */
    List<District> findByPid(Long pid) throws Exception;
}
