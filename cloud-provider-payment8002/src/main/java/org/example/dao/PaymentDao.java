package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entities.Payment;

/**
 * Classname:PaymentDao
 * Package:org.example.dao
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/10 - 17:01
 * @Version: V1.0
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
