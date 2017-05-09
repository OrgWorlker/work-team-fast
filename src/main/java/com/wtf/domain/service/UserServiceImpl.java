package com.wtf.domain.service;

import com.wtf.domain.model.User;
import com.wtf.interfaces.repository.IUserMapper;
import com.wtf.interfaces.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * The type User service.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, IUserMapper> implements IUserService {

    @Override
    public User findByUserName(String userName) {
        return this.getMapper().findByUserName(userName);
    }

}
