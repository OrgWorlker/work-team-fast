package com.wtf.core.domain.service;


import com.wtf.core.domain.model.User;
import com.wtf.core.interfaces.repository.IUserMapper;
import com.wtf.core.interfaces.service.IUserService;
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

    /**
     * Find by phone num user.
     *
     * @param phoneNum the phone num
     * @return the user
     */
    @Override
    public User findByPhoneNum(String phoneNum) {
        return this.getMapper().findByPhoneNum(phoneNum);
    }

}
