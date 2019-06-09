package com.huantt.annotationexample;

import com.huantt.annotationexample.annotation.json.YMLWriter;
import com.huantt.annotationexample.model.Category;
import com.huantt.annotationexample.model.Product;

/**
 * @author huantt on 2019-06-08
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Product product = new Product("0001", 200000D, new Category("machine"));

        System.out.println(YMLWriter.writeAsString(product));
    }
}
