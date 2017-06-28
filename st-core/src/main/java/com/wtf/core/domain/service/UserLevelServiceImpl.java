package com.wtf.core.domain.service;


import com.wtf.core.domain.model.User;
import com.wtf.core.domain.model.UserLevel;
import com.wtf.core.interfaces.repository.IUserLevelMapper;
import com.wtf.core.interfaces.service.IUserLevelService;
import com.wtf.core.interfaces.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * The type User level service.
 */
@Service
public class UserLevelServiceImpl extends BaseServiceImpl<UserLevel, IUserLevelMapper> implements IUserLevelService {

    @Resource
    private IUserService userService;

    @Override
    public UserLevel findByUserId(Long userId) {
        final User user = this.userService.findById(userId);
        return user.getUserLevel();
    }
}
