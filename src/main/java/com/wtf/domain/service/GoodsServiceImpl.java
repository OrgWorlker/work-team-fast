package com.wtf.domain.service;

import com.wtf.domain.model.Goods;
import com.wtf.interfaces.repository.IGoodsMapper;
import com.wtf.interfaces.service.IGoodsService;
import org.springframework.stereotype.Service;

/**
 * The type Goods service.
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods, IGoodsMapper> implements IGoodsService {

}
