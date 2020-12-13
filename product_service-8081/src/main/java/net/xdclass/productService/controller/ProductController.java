package net.xdclass.productService.controller;

import net.xdclass.productService.domain.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import net.xdclass.productService.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
* @Description: 服务生产者
* @Param:
* @return:
* @Author: ma.kangkang
* @Date: 2019/8/22
*/
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;

    @Autowired
    private DiscoveryClient discoveryClient;

   /**
   * @Description: 获取商品列表
   * @Param:
   * @return:
   * @Author: ma.kangkang
   * @Date: 2019/8/22
   */
    @RequestMapping("list")
    public Object list(){

        return productService.listProduct();
    }

    /**
    * @Description: 根据商品id获取商品详情
    * @Param:
    * @return:
    * @Author: ma.kangkang
    * @Date: 2019/8/23
    */
    @RequestMapping("find")
    public Object findById(@RequestParam("id") int id){
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName(result.getName()+"data from port="+port);
        return result;
    }

    @RequestMapping("/discovery")
    public Object discoveryHandle() {
        List<List<ServiceInstance>> servicesList = new ArrayList<>();
        // 获取到服务列表中所有微服务名称，例如product-service
        List<String> serviceNames = discoveryClient.getServices();
        //遍历所有服务名称
        for (String name : serviceNames) {
            //获取指定名称的所有服务提供者的主机
            List<ServiceInstance> instances = discoveryClient.getInstances(name);
            // 遍历指定名称的所有主机
            for (ServiceInstance instance : instances) {
                String host = instance.getHost();
                int port = instance.getPort();
                System.out.println("host:" + host + ",port:" + port);
            }
            servicesList.add(instances);
        }
        return servicesList;
    }
}
