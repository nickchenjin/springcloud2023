package org.example.service;

import feign.Param;
import org.example.entities.CommonResult;
import org.example.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Classname:PaymentFeignService
 * Package:org.example.service
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/12 - 20:02
 * @Version: V1.0
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    public String paymentFeignTimeout();
}
