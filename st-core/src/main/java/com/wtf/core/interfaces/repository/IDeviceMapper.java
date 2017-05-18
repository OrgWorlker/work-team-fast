package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.Device;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface Device mapper.
 */
@Mapper
public interface IDeviceMapper extends BaseMapper<Device> {

}
