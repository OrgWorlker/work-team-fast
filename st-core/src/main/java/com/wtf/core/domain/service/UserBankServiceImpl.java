package com.wtf.core.domain.service;

import com.wtf.core.domain.model.UserBank;
import com.wtf.core.interfaces.repository.IUserBankMapper;
import com.wtf.core.interfaces.service.IUserBankService;
import org.springframework.stereotype.Service;

/**
 * The type User bank service.
 */
@Service
public class UserBankServiceImpl extends BaseServiceImpl<UserBank, IUserBankMapper> implements IUserBankService {


    /**
     * Find by user id user bank.
     *
     * @param userId the user id
     * @return the user bankuserId
     */
    @Override
    public UserBank findByUserId(Long userId) {
        return this.getMapper().findByUserId(userId);
    }
}
