package com.weilin.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Category implements java.io.Serializable{
    private String categoryName;
    private int categoryId;
    private String description;
    private Boolean active;

    public Category(){

    }
    public Category(String categoryName){this.categoryName=categoryName;}
    public Category(String categoryName,String description,Boolean active){
        this.categoryName=categoryName;
        this.description=description;
        this.active=active;
    }
    public  int getCategoryId(){return  this.categoryId;}
    public void setCategoryName(int categoryId){this.categoryId=categoryId;}
    public String getCategoryName(){return  this.description;}
    public  void setCategoryName(String categoryName){this.categoryName=categoryName;}
    public String getDescription(String description){this.description=description;}
    public void setDescription(String description){this.description=description;}
    public Boolean getActive(){return  this.active;}
    public void setActive(Boolean active){this.active=active;}
    public static List<Category>findAllCategory(Connection connection con){
        List<Category> list=new ArrayList<Category>();
        String querString="select * from Category";

    }


}
