package com.icommerce.icommerceproject.dto.request;

import com.icommerce.icommerceproject.entity.ShoppingSession;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link ShoppingSession} entity
 */
@Data
public class ShoppingSessionRequestDto implements Serializable {
    private Integer id;
    private Integer userId;
    private BigDecimal total;
}