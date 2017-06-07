package com.wtf.core.interfaces.service;

import com.wtf.core.domain.model.District;

import java.util.List;

/**
 * The interface District service.
 */
public interface IDistrictService extends IBaseService<District>{

    List<District> findByPid(Long pid) throws Exception;
}
