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
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

//    新品功能
    @PostMapping("/api/products")
    public ResponseEntity<Response> createProduct(@RequestBody @Valid ProductInput productInput) {
            Response response = productService.createProduct(productInput);

         return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    透過條碼查詢資料
    @GetMapping("/api/product/{barcode}")
    public ResponseEntity<Response> getProduct(@PathVariable String barcode) {
        Response response= productService.getProductByBarcode(barcode);
        if (response.getProduct()==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }

}
