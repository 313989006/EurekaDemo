package com.mxk.demo.service;



import com.mxk.demo.domain.Consumer;
import com.mxk.demo.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @Description: 服务层
* @Param:
* @return:
* @Author: ma.kangkang
* @Date: 2019/8/22
*/
// @FeignClient 指定该客户端要访问的提供者微服务名称
@FeignClient("product-service")
@RequestMapping("/provider/product")
public interface ProductService {

    @PostMapping("/save")
    boolean saveProduct(@RequestBody Product product);


    @DeleteMapping("/del/{id}")
    boolean removeProductById(@PathVariable("id") int id);

    @PutMapping("update")
    boolean update(@RequestBody Product product);

    @GetMapping("/get/{id}")
    Product getById(@PathVariable("id") int id);

    @GetMapping("/list")
    List<Product> listAllProducts();
}
