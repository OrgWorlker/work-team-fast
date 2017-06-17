package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.UserBank;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface User bank mapper.
 */
@Mapper
public interface IUserBankMapper extends BaseMapper<UserBank> {

    /**
     * Find by user id user bank.
     *
     * @param userId the user id
     * @return the user bank
     */
    UserBank findByUserId(Long userId);
}
