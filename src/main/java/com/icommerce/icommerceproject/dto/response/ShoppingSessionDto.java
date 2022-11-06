package com.icommerce.icommerceproject.dto.response;

import com.icommerce.icommerceproject.entity.ShoppingSession;
import com.icommerce.icommerceproject.entity.User;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link ShoppingSession} entity
 */
@Data
@Builder
public class ShoppingSessionDto implements Serializable {
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;
    private LocalDateTime modifiedOn;
    private Integer id;
    private BigDecimal total;
    private User user;
}