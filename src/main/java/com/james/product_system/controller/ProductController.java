package com.james.product_system.controller;

import com.james.product_system.dto.ProductInput;
import com.james.product_system.dto.Response;
import com.james.product_system.model.Product;
import com.james.product_system.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/products")
    public ResponseEntity<Response> createProduct(@RequestBody @Valid ProductInput productInput) {
            Response response = productService.createProduct(productInput);

         return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    查詢所有資料
//    @GetMapping("/users/product")
//    public ResponseEntity<Product> getProduct(){
//        Product product= productService.getPeoduct();
//        if (product == null) {
//            return ResponseEntity.status(HttpStatus.OK).body(product);
//
//        }else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(product);
//        }
//    }

}
