package com.wtf.interfaces.repository;

import com.wtf.domain.model.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface Goods mapper.
 */
@Mapper
public interface IGoodsMapper extends BaseMapper<Goods> {

}