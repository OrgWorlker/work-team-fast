package com.wtf.core.domain.manager;

import com.wtf.core.domain.model.TbUser;
import com.wtf.core.infrastructure.stereotype.Manager;
import com.wtf.core.interfaces.manager.ITbUserManager;
import com.wtf.core.interfaces.service.ITbUserService;

import javax.annotation.Resource;
import java.util.List;


/**
 * The type Tb user manager.
 */
@Manager
public class TbUserManagerImpl implements ITbUserManager {

    /**
     * The Tb user service.
     */
    @Resource
    private ITbUserService tbUserService;
    @Override
    public List<TbUser> findTbUserNumByUserId(Long userId) throws Exception {
        return this.tbUserService.findTbUserNumByUserId(userId);
    }
}