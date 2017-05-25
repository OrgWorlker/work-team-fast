package com.wtf.core.domain.manager;

import com.wtf.core.domain.model.Goods;
import com.wtf.core.infrastructure.stereotype.Manager;
import com.wtf.core.interfaces.manager.IGoodsManager;
import com.wtf.core.interfaces.service.IGoodsService;

import javax.annotation.Resource;

/**
 * The type Goods manager.
 */
@Manager
public class GoodsManagerImpl implements IGoodsManager {

    @Resource
    private IGoodsService goodsService;

    @Override
    public Goods findById(Long id) throws Exception {
        return this.goodsService.findById(id);
    }

}
