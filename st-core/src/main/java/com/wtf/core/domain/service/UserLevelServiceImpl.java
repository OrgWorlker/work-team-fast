package com.wtf.core.domain.service;


import com.wtf.core.domain.model.UserLevel;
import com.wtf.core.interfaces.repository.IUserLevelMapper;
import com.wtf.core.interfaces.service.IUserLevelService;
import org.springframework.stereotype.Service;

/**
 * The type User level service.
 */
@Service
public class UserLevelServiceImpl extends BaseServiceImpl<UserLevel, IUserLevelMapper> implements IUserLevelService {

}
