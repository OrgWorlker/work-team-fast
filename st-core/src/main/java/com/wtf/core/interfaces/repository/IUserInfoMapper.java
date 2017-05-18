package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface User info mapper.
 */
@Mapper
public interface IUserInfoMapper extends BaseMapper<UserInfo> {

}