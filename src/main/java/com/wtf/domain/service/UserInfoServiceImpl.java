package com.wtf.domain.service;

import com.wtf.domain.model.UserInfo;
import com.wtf.interfaces.repository.IUserInfoMapper;
import com.wtf.interfaces.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * The type User info service.
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, IUserInfoMapper> implements IUserInfoService {

}
