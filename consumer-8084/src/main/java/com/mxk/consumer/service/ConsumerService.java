package com.mxk.consumer.service;


import com.mxk.consumer.domain.Consumer;

import java.util.List;

/**
* @Description: 服务层
* @Param:
* @return:
* @Author: ma.kangkang
* @Date: 2019/8/22
*/
public interface ConsumerService {

    List<Consumer> listProduct();

    Consumer findById(Integer id);
}
