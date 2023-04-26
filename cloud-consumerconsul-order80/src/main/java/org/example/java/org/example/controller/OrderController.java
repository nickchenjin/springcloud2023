package org.example.java.org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.CommonResult;
import org.example.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Classname:OrderController
 * Package:org.example.controller
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/10 - 19:16
 * @Version: V1.0
 */

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate ;

    //private static final String PURL="http://CLOUD-PAYMENT-SERVICE";
    private static final String PURL="http://cloud-payment-service";

    @GetMapping("/consumer/payment/paymentconsul")
    public CommonResult paymentconsul()
    {
      return new  CommonResult(200, "success " ,restTemplate.getForObject(PURL+"/payment/consul" , String.class) )  ;
    }

    @GetMapping (value = "/consumer/payment/create")
    public CommonResult create(Payment payment)
    {
        CommonResult result =  restTemplate.postForObject(PURL +"/payment/create",payment,CommonResult.class) ;
        log.info("insert result : " + result);
        if (result != null) {
            return result;
        }
        else {
            return  new CommonResult(404 ,"insert fail " , null);
        }

    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id)
    {
        CommonResult result =restTemplate.getForObject(PURL +"/payment/get/"+id , CommonResult.class);
        log.info("insert result : " + result);
        if (null !=result)
        {
            return  result;
        }
        else {
            return  new CommonResult(404 ,"get fail " , null);
        }
    }

}
