package org.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.example.entities.CommonResult;
import org.example.entities.Payment;
import org.example.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Classname:OrderFeignController
 * Package:org.example.controller
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/12 - 20:09
 * @Version: V1.0
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value="/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })
    public String paymentTimeout(@PathVariable("id") Integer id)
    {
       return paymentFeignService.paymentTimeout(id);
    }

    public String paymentInfo_TimeOutHandler(Integer id)
    {
        return "消费端  线程池： " + Thread.currentThread().getName()+ " consumer  系统繁忙，系统出错，请稍后再试试 id : " + id + "\t" + "  特殊处理" ;

    }

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id)
    {
        return paymentFeignService.paymentinfo_ok(id);
    }
}
