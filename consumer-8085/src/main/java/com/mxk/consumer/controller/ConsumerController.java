package com.mxk.consumer.controller;

import com.mxk.consumer.domain.Consumer;
import com.mxk.consumer.service.ConsumerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
* @Description: 服务生产者
* @Param:
* @return:
* @Author: ma.kangkang
* @Date: 2019/8/22
*/
@RestController
@RequestMapping("/api/v1/consumer")
public class ConsumerController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_PROVIDOR = "http://product-service";

   /**
   * @Description: 获取商品列表
   * @Param:
   * @return:
   * @Author: ma.kangkang
   * @Date: 2019/8/22
   */
    @RequestMapping("/list")
    public Object list(){

        return consumerService.listProduct();
    }

    /**
    * @Description: 根据商品id获取商品详情
    * @Param:
    * @return:
    * @Author: ma.kangkang
    * @Date: 2019/8/23
    */
    @RequestMapping("/find")
    public Object findById(@RequestParam("id") int id){
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Consumer consumer = consumerService.findById(id);
        Consumer result = new Consumer();
        BeanUtils.copyProperties(consumer,result);
        result.setName(result.getName()+"data from port="+port);
        return result;
    }

    @RequestMapping("/list2")
    public Object getList(@RequestBody Consumer consumer){
        String url = SERVICE_PROVIDOR + "/api/v1/product/list";
        return restTemplate.postForObject(url, consumer,Object.class);
    }
}
