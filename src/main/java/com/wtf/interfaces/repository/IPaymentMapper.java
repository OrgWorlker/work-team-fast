package com.wtf.interfaces.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.wtf.domain.model.Payment;

/**
 * The interface Payment mapper.
 */
@Mapper
public interface IPaymentMapper extends BaseMapper<Payment> {

}