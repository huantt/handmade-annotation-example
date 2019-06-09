package com.huantt.annotationexample.model;

import com.huantt.annotationexample.annotation.json.YMLNaming;

/**
 * @author huantt on 2019-06-08
 */
public class Product {

    public Product(String skuCode, Double price) {
        this.skuCode = skuCode;
        this.price = price;
    }

    @YMLNaming("sku")
    private String skuCode;
    private Double price;

}
