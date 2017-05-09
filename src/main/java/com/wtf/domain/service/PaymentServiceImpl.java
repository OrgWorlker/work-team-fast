package com.wtf.domain.service;

import com.wtf.domain.model.Payment;
import com.wtf.interfaces.repository.IPaymentMapper;
import com.wtf.interfaces.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Payment service.
 */
@Service
public class PaymentServiceImpl extends BaseServiceImpl<Payment, IPaymentMapper> implements IPaymentService {

}
