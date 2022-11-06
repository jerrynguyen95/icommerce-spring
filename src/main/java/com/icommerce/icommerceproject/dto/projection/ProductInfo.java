package com.icommerce.icommerceproject.dto.projection;

import com.icommerce.icommerceproject.entity.ProductCategory;
import com.icommerce.icommerceproject.entity.ProductDiscount;

import java.math.BigDecimal;

/**
 * A Projection for the {@link com.icommerce.icommerceproject.entity.Product} entity
 */
public interface ProductInfo {

    Integer getId();

    String getName();

    String getDescription();

    String getSKU();

    BigDecimal getCost();

    Integer getQuantity();

    ProductCategory getCategory();

    String getImageUrl();

    ProductDiscount getDiscount();
}