package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.UserOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface User mapper.
 */
@Mapper
public interface IUserOrderMapper extends BaseMapper<UserOrder> {

    /**
     * Find by user name user.
     *
     * @param userId the user id
     * @return the user
     */
    UserOrder findByUserId(Long userId);

}

