package org.example.service.impl;

import org.example.dao.PaymentDao;
import org.example.entities.Payment;
import org.example.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Classname:PaymentServiceImpl
 * Package:org.example.service.impl
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/10 - 17:18
 * @Version: V1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
