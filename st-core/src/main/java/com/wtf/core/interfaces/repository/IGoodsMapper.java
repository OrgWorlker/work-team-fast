package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface Goods mapper.
 */
@Mapper
public interface IGoodsMapper extends BaseMapper<Goods> {

}