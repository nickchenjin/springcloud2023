package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.CommonResult;
import org.example.entities.Payment;
import org.example.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;
    private static final String PURL="http://CLOUD-PAYMENT-SERVICE";

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

    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id)
    {
        //CommonResult result =restTemplate.getForObject(PURL +"/payment/get/"+id , CommonResult.class);
        ResponseEntity<CommonResult> entity =    restTemplate.getForEntity(PURL +"/payment/get/"+id ,CommonResult.class);
        log.info("insert result : " + entity);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return  entity.getBody();
        }
        else {
            return  new CommonResult(404 ," getForEntity fail " , null);
        }
    }


    @GetMapping(value="/consumer/payment/lb")
    public String getPaymentLB()
    {

        List<ServiceInstance> serviceInstance = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(serviceInstance==null || serviceInstance.size()<0)
        {
            return null ;
        }
        ServiceInstance ss = loadBalancer.instances(serviceInstance);
        URI url = ss.getUri();
        return restTemplate.getForObject(url+"/payment/lb",String.class);

    }

}
