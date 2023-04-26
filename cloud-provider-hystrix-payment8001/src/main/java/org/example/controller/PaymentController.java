package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.CommonResult;
import org.example.entities.Payment;
import org.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


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

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("insert result : " + result);
        if (result>0)
        {
            return  new CommonResult(200 , "insert success" +serverPort ,result);
        }
        else {
            return  new CommonResult(404 ,"insert fail " + serverPort, null);
        }
    }

    @GetMapping (value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment result = paymentService.getPaymentById(id);
        log.info("insert result : " + result);
        if (null !=result)
        {
            return  new CommonResult(200 , "get success "+serverPort ,result);
        }
        else {
            return  new CommonResult(404 ,"get fail "+serverPort , null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery()
    {
        List<String> listString = discoveryClient.getServices();
        for (String tmp : listString  ) {
            log.info("getAllKnownRegions " + tmp );
        }
        List<ServiceInstance> serviceInstance = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance tmpIns:serviceInstance){
            log.info(tmpIns.getServiceId() +"\t "+ tmpIns.getHost() +"\t " + tmpIns.getPort() +"\t " + tmpIns.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value="/payment/lb")
    public String getPaymentLb()
    {
        return  serverPort;
    }

    @GetMapping(value="/payment/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return serverPort;
    }


    @GetMapping(value="/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id) {

        String result =  paymentService.paymentInfo_timeout(id);
        log.info(" ****result " +  result);
        return result;
    }

    @GetMapping(value="/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_ok(id);
        log.info(" ****result " +  result);
        return result;
    }
}
