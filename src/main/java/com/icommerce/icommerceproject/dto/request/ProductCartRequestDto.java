package com.icommerce.icommerceproject.dto.request;

import com.icommerce.icommerceproject.entity.ShoppingSession;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link ShoppingSession} entity
 */
@Data
public class ProductCartRequestDto implements Serializable {
    private Integer id;
    private Integer quantity;
    private Integer userId;
    private Integer productId;
    private Integer sessionId;
    private BigDecimal total;
}