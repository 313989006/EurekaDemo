package net.xdclass.productService.controller;

import com.netflix.discovery.converters.Auto;
import net.xdclass.productService.domain.Product;
import net.xdclass.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ProviderProductController
 * @Description TODO
 * @Author ma.kangkang
 * @Date 2020/12/20 14:26
 **/
@RestController
@RequestMapping("/provider/product")
public class ProviderProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable("id") int id){
        return  service.findById(id);
    }

    @GetMapping("/list")
    public List<Product> getProducts(){
        return  service.listProduct();
    }
}
