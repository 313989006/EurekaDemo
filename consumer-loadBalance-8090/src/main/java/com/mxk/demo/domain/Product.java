package com.mxk.demo.domain;

/**
* @Description: 生产者实体类
* @Param:
* @return:
* @Author: ma.kangkang
* @Date: 2019/8/23
*/
public class Product {

    public Product(){

    }

    public Product(int id, String name, int price, int store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    private int id;

    //商品名
    private String name;

    //价格，分为单位
    private int price;
    //库存
    private int store;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }
}
