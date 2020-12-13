package net.xdclass.productService.service;


import net.xdclass.productService.domain.Product;

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
