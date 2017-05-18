package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface Payment mapper.
 */
@Mapper
public interface IPaymentMapper extends BaseMapper<Payment> {

}