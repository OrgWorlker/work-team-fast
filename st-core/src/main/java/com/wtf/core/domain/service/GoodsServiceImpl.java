package com.wtf.core.domain.service;

import com.wtf.core.domain.model.Goods;
import com.wtf.core.interfaces.repository.IGoodsMapper;
import com.wtf.core.interfaces.service.IGoodsService;
import org.springframework.stereotype.Service;

/**
 * The type Goods service.
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods, IGoodsMapper> implements IGoodsService {

}
