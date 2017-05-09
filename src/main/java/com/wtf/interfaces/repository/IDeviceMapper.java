package com.wtf.interfaces.repository;

import com.wtf.domain.model.UserLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.wtf.domain.model.Device;

/**
 * The interface Device mapper.
 */
@Mapper
public interface IDeviceMapper extends BaseMapper<Device> {

}
