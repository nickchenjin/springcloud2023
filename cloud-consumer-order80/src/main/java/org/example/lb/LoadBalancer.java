package org.example.lb;

import org.springframework.cloud.client.ServiceInstance;

import javax.xml.ws.Service;
import java.util.List;

/**
 * Classname:LoadBalancer
 * Package:com.rule.lb
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/12 - 16:50
 * @Version: V1.0
 */
public interface LoadBalancer {
    ServiceInstance instances (List<ServiceInstance>  serviceInstances );
}
