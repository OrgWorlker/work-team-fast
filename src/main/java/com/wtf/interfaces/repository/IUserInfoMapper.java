package com.wtf.interfaces.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.wtf.domain.model.UserInfo;

/**
 * The interface User info mapper.
 */
@Mapper
public interface IUserInfoMapper extends BaseMapper<UserInfo> {

}