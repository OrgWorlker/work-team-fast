package com.wtf.core.domain.service;


import com.wtf.core.domain.model.Payment;
import com.wtf.core.interfaces.repository.IPaymentMapper;
import com.wtf.core.interfaces.service.IPaymentService;
import org.springframework.stereotype.Service;

/**
 * The type Payment service.
 */
@Service
public class PaymentServiceImpl extends BaseServiceImpl<Payment, IPaymentMapper> implements IPaymentService {

}
