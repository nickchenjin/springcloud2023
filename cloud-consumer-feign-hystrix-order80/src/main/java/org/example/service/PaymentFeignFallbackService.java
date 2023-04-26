package org.example.service;

import org.springframework.stereotype.Component;

/**
 * Classname:PaymentFeignFallbackService
 * Package:org.example.service
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/24 - 14:55
 * @Version: V1.0
 */
@Component
public class PaymentFeignFallbackService implements  PaymentFeignService{
    @Override
    public String paymentTimeout(Integer id) {
        return "fall back  paymentTimeout   ";
    }

    @Override
    public String paymentinfo_ok(Integer id) {
        return "all back  paymentinfo_ok  ";
    }
}
