package com.wtf.core.domain.service;

import com.wtf.core.domain.model.TbUser;
import com.wtf.core.interfaces.repository.ITbUserMapper;
import com.wtf.core.interfaces.service.ITbUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Tb user service.
 */
@Service
public class TbUserServiceImpl extends BaseServiceImpl<TbUser, ITbUserMapper> implements ITbUserService {


    @Override
    public List<TbUser> findTbUserNumByUserId(Long userId) throws Exception {
        return this.getMapper().findTbUserNumByUserId(userId);
    }
}
