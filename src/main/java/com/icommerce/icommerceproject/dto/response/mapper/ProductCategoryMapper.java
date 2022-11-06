package com.icommerce.icommerceproject.dto.response.mapper;

import com.icommerce.icommerceproject.dto.response.ProductCategoryDto;
import com.icommerce.icommerceproject.entity.ProductCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper{

    ProductCategoryDto toDto(ProductCategory productCategory);

    ProductCategory toEntity(ProductCategoryDto productCategoryDto);
}
