package com.james.product_system.dao.impl;

import com.james.product_system.dao.ProductDao;
import com.james.product_system.dto.ProductInput;
import com.james.product_system.model.Product;
import com.james.product_system.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    輸入新產品
    @Override
    public Integer createProduct(ProductInput productInput) {
        String sql = "INSERT INTO Products (name, category, barcode, created_at, updated_at) " +
                "VALUES (:name, :category, :barcode, :createdDate, :lastModifiedDate)";
        Map<String, Object> map = new HashMap<>();
        map.put("name", productInput.getName());
        map.put("category", productInput.getCategory().toString());
        map.put("barcode", productInput.getBarcode());


        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);

        int productId = keyHolder.getKey().intValue();

        return productId;
    }

//    透過productId查詢資料
    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, name, category, barcode, total_stock, created_at, updated_at " +
                "FROM Products WHERE product_id = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if (productList.size() > 0) {
            System.out.println(productList.get(0));
            return productList.get(0);
        } else {

            return null;
        }
    }

//    透果條碼確定資料庫有無資料
    @Override
    public Product getProductByBarcode(String barcode) {
        String sql = "SELECT product_id, name, category, barcode, total_stock, created_at, updated_at " +
                "FROM Products WHERE barcode = :barcode";
        Map<String, Object> map = new HashMap<>();
        map.put("barcode", barcode);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            System.out.println(productList.get(0));
            return productList.get(0);
        } else {

            return null;
        }

    }
}
