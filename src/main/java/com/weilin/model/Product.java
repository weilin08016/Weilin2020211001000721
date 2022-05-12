package com.weilin.model;

import java.io.InputStream;

public class Product {
    private Integer productId;
    private Integer categoryId;
    private String productName;
    private String productDescription;
    private InputStream picture;
    private Double price;

    public Product(){

    }
    public Product(Integer categoryId,String productName,String productDescription,InputStream picture,Double price){
        this.categoryId=categoryId;
        this.productName=productName;
        this.productDescription=productDescription;
        this.picture=picture;
        this.price=price;
    }
    public Integer getProductId(){return  this.productId;}
    public void setProductId(Integer productId){this.productId=productId;}
    @Override
    public String toString(){

    }

}
