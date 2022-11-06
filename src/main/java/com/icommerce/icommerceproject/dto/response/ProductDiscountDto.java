package com.icommerce.icommerceproject.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.icommerce.icommerceproject.entity.ProductDiscount} entity
 */
@Data
public class ProductDiscountDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal discount;
    private boolean active;
}