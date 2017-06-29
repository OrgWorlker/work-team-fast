package com.wtf.core.interfaces.service;


import com.wtf.core.domain.model.UserLevel;
import org.springframework.stereotype.Service;

/**
 * The type User level service.
 */
@Service
public interface IUserLevelService extends IBaseService<UserLevel> {

    UserLevel findByUserId(Long userId);
}
