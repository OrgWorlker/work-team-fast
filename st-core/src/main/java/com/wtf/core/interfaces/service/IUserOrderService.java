package com.wtf.core.interfaces.service;


import com.wtf.core.domain.model.UserOrder;

/**
 * The type User info service.
 */
public interface IUserOrderService extends IBaseService<UserOrder> {

    /**
     * Find by user id user order.
     *
     * @param userId the user id
     * @return the user order
     * @throws Exception the exception
     */
    UserOrder findByUserId(Long userId) throws Exception;
}