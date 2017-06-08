package com.wtf.core.domain.service;


import com.wtf.core.domain.model.UserOrder;
import com.wtf.core.interfaces.repository.IUserOrderMapper;
import com.wtf.core.interfaces.service.IUserOrderService;
import org.springframework.stereotype.Service;

/**
 * The type User info service.
 */
@Service
public class UserOrderServiceImpl extends BaseServiceImpl<UserOrder, IUserOrderMapper> implements IUserOrderService {

    /**
     * Find by user id user order.
     *
     * @param userId the user id
     * @return the user order
     * @throws Exception the exception
     */
    @Override
    public UserOrder findByUserId(Long userId) throws Exception {
        return this.getMapper().findByUserId(userId);
    }
}
