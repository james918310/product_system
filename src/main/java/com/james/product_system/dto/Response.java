package com.james.product_system.dto;

import com.james.product_system.model.Product;

public class Response<T> {
    private String message;
    private Product product;
    private T data;

    public Response(String message,Product product, T data) {
        this.message = message;
        this.product = product;
        this.data = data;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

