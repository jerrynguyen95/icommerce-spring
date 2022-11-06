package com.icommerce.icommerceproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.icommerce.icommerceproject.entity.Product} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String SKU;
    private BigDecimal cost;
    private ProductCategoryDto category;
    private ProductDiscountDto discount;
    private Integer quantity;
    private String imageUrl;
}