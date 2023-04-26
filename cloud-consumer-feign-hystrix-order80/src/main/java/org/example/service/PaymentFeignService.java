package org.example.service;

import org.example.entities.CommonResult;
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
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFeignFallbackService.class)
@Component
public interface PaymentFeignService {

    @GetMapping(value="/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id);

    @GetMapping(value="/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id);
}
