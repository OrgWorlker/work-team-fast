package com.wtf.core.domain.service;


import com.wtf.core.domain.model.UserInfo;
import com.wtf.core.interfaces.repository.IUserInfoMapper;
import com.wtf.core.interfaces.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * The type User info service.
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, IUserInfoMapper> implements IUserInfoService {

}
