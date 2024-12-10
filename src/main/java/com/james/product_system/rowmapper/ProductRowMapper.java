package com.james.product_system.rowmapper;

import com.james.product_system.constant.ProductCategory;
import com.james.product_system.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setName(rs.getString("name"));

        String categoryStr = rs.getString("category");
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        product.setCategory(category);

        product.setBarcode(rs.getString("barcode"));
        product.setTotal_stock(rs.getInt("total_stock"));
        product.setCreatedDate(rs.getTimestamp("created_at"));
        product.setLastModifiedDate(rs.getTimestamp("updated_at"));

        return product;
    }
}
