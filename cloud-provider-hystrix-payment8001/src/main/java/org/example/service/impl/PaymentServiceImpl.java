package org.example.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.example.dao.PaymentDao;
import org.example.entities.Payment;
import org.example.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池： " + Thread.currentThread().getName()+ "  paymentInfo_ok id : " + id + "\t" + "  哈哈";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_timeout(Integer id) {
        int timeout = 5;
        //int age =  10/0;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池： " + Thread.currentThread().getName()+ "  paymentInfo_timeout id : " + id + "\t" + "  哭哭哭" + "耗时" + timeout +"秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id)
    {
        return "线程池： " + Thread.currentThread().getName()+ "  系统繁忙，系统出错，请稍后再试试 id : " + id + "\t" + "  特殊处理" ;

    }
}
