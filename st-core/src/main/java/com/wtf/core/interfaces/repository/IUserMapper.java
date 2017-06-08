package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.User;
import org.apache.ibatis.annotations.Mapper;

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

    /**
     * Find by phone num user.
     *
     * @param phoneNum the phone num
     * @return the user
     */
    User findByPhoneNum(String phoneNum);
}

