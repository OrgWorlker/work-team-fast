package com.wtf.interfaces.repository;

import com.wtf.domain.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface User mapper.
 */
@Mapper
public interface IUserMapper extends BaseMapper<User> {

    /**
     * Find by user name user.
     *
     * @param userName the user name
     * @return the user
     */
    User findByUserName(String userName);

}

