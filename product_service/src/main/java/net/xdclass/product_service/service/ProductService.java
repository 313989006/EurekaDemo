package net.xdclass.product_service.service;

import net.xdclass.product_service.domain.Product;

import java.util.List;

/**
* @Description: 服务层
* @Param:
* @return:
* @Author: ma.kangkang
* @Date: 2019/8/22
*/
public interface ProductService {

    List<Product> listProduct();

    Product findById(Integer id);
}
