package com.icommerce.icommerceproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.icommerce.icommerceproject.entity.ProductCategory} entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductCategoryDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
}