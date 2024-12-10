package com.james.product_system.dto;

import com.james.product_system.constant.ProductCategory;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;

public class ProductInput {


    @NotNull
    private String name;
    @NotNull
    private ProductCategory category;
    @NotNull
    private String barcode;
//    @NotNull
//    private Integer total_stock;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

//    public Integer getTotal_stock() {
//        return total_stock;
//    }

//    public void setTotal_stock(Integer total_stock) {
//        this.total_stock = total_stock;
//    }


}
