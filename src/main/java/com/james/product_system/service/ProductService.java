package com.james.product_system.service;

import com.james.product_system.dto.ProductInput;
import com.james.product_system.dto.Response;
import com.james.product_system.model.Product;

public interface ProductService {
    Response<Integer> createProduct(ProductInput productInput);

    Product getProductById(Integer id);

    Response<Integer> getProductByBarcode (String barcode);
}
