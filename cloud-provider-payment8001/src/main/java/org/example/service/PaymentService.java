package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entities.Payment;

/**
 * Classname:PaymentService
 * Package:org.example.service
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/10 - 17:17
 * @Version: V1.0
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
