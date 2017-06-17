package com.wtf.core.interfaces.service;

import com.wtf.core.domain.model.UserBank;

/**
 * The interface User bank service.
 */
public interface IUserBankService extends IBaseService<UserBank> {

    /**
     * Find by user id user bank.
     *
     * @param userId the user id
     * @return the user bank
     */
    UserBank findByUserId (Long userId);
}
