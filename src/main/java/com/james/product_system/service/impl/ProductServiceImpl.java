package com.james.product_system.service.impl;

import com.james.product_system.dao.ProductDao;
import com.james.product_system.dto.ProductInput;
import com.james.product_system.dto.Response;
import com.james.product_system.model.Product;
import com.james.product_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Response<Integer> createProduct(ProductInput productInput) {
         Product product = productDao.getProductByBarcode(productInput.getBarcode());
//        確認資料庫裡有無一樣的條碼
         if (product == null) {
             Integer productId = productDao.createProduct(productInput);
             Product productNew = productDao.getProductById(productId);
             return new Response<>("商品創建成功",productNew ,productId);
         }else {
             return new Response<>("已有資料",product, product.getProductId());
         }

    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
