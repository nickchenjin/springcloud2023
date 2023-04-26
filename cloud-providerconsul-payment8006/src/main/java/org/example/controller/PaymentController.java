package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.CommonResult;
import org.example.entities.Payment;
import org.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Classname:PaymentController
 * Package:org.example.controller
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/10 - 17:20
 * @Version: V1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService ;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentzk()
    {
        return " springcloud with consul :  "+serverPort + "\t" + UUID.randomUUID().toString();
    }

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("insert result : " + result);
        if (result>0)
        {
            return  new CommonResult(200 , "insert success " +serverPort,result);
        }
        else {
            return  new CommonResult(404 ,"insert fail "+serverPort , null);
        }
    }

    @GetMapping (value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id)
    {
        Payment result = paymentService.getPaymentById(id);
        log.info("insert result : " + result);
        if (null !=result)
        {
            return  new CommonResult(200 , "get success " +serverPort,result);
        }
        else {
            return  new CommonResult(404 ,"get fail " +serverPort, null);
        }
    }

}
