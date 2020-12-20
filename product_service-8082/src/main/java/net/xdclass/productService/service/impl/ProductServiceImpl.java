package net.xdclass.productService.service.impl;

import net.xdclass.productService.domain.Product;
import net.xdclass.productService.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    private static Map<Integer,Product> daoMap = new HashMap<>();

    static {
        Product p1= new Product(1,"iphonex",9999,10);
        Product p2= new Product(2,"冰箱2",6666,120);
        Product p3= new Product(3,"电话",122,130);
        Product p4= new Product(4,"电视",1999,150);
        Product p5= new Product(5,"茶杯",10,110);
        Product p6= new Product(6,"轿车",500000,10);
        Product p7= new Product(7,"java核心技术",99,100);

        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
        daoMap.put(p6.getId(),p6);
        daoMap.put(p7.getId(),p7);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(Integer id) {
        Product product = new Product();
        product.setName("冰箱222");
        product.setPrice(222);
        product.setStore(222);
        return product;
    }
}
