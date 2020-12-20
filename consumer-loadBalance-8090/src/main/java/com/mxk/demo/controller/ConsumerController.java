package com.mxk.demo.controller;

import com.mxk.demo.domain.Product;
import com.mxk.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @Description: 服务生产者
* @Param:
* @return:
* @Author: ma.kangkang
* @Date: 2019/8/22
*/
@RestController
@RequestMapping("/consumer/product")
public class ConsumerController {

    @Autowired
    private ProductService service;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @DeleteMapping("/del/{id}")
    boolean removeProductById(@PathVariable("id") int id){
        return service.removeProductById(id);
    }

    @PutMapping("update")
    boolean update(@RequestBody Product product){
        return service.update(product);
    }

    @GetMapping("/get/{id}")
    Product getById(@PathVariable("id") int id){
        Product product = service.getById(id);
        return product;
    }

    @GetMapping("/list")
    List<Product> listAllProducts(){
        List<Product> products = service.listAllProducts();
        return products;
    }

}
