package com.mxk.consumer.service.impl;

import com.mxk.consumer.domain.Consumer;
import com.mxk.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
* @Description: 实现类
* @Param:
* @return:
* @Author: ma.kangkang
* @Date: 2019/8/22
*/
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private static Map<Integer, Consumer> daoMap = new HashMap<>();

    static {
        Consumer p1= new Consumer(1,"iphonex",9999,10);
        Consumer p2= new Consumer(2,"冰箱",6666,120);
        Consumer p3= new Consumer(3,"电话",122,130);
        Consumer p4= new Consumer(4,"电视",1999,150);
        Consumer p5= new Consumer(5,"茶杯",10,110);
        Consumer p6= new Consumer(6,"轿车",500000,10);
        Consumer p7= new Consumer(7,"java核心技术",99,100);

        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
        daoMap.put(p6.getId(),p6);
        daoMap.put(p7.getId(),p7);
    }

    @Override
    public List<Consumer> listProduct() {
        Collection<Consumer> collection = daoMap.values();
        List<Consumer> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Consumer findById(Integer id) {
        return daoMap.get(id);
    }
}
