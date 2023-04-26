package org.example.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classname:MyLB
 * Package:com.rule.lb
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/12 - 16:52
 * @Version: V1.0
 */

@Component
public class MyLB implements  LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement()
    {
        int current ;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current>=2147483647 ? 0 : current+1;
            System.out.println("next   ---  "+next );
        } while(!this.atomicInteger.compareAndSet(current,next));
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
