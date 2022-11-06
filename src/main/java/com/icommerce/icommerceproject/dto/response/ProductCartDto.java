package com.icommerce.icommerceproject.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.icommerce.icommerceproject.entity.ProductCart} entity
 */
@Data
@Builder
public class ProductCartDto implements Serializable {
    private Integer id;
    private ShoppingSessionDto shoppingSession;
    private ProductDto product;
    private Integer quantity;
}