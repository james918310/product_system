package com.james.product_system.dao;

import com.james.product_system.dto.ProductInput;
import com.james.product_system.model.Product;

public interface ProductDao {

    Integer createProduct(ProductInput productInput);

    Product getProductById(Integer productId);

    Product getProductByBarcode(String barcode);

}
