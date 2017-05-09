package com.wtf.domain.service;

import com.wtf.domain.model.UserLevel;
import com.wtf.interfaces.repository.IUserLevelMapper;
import com.wtf.interfaces.service.IUserLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type User level service.
 */
@Service
public class UserLevelServiceImpl  extends BaseServiceImpl<UserLevel, IUserLevelMapper> implements IUserLevelService {

}
