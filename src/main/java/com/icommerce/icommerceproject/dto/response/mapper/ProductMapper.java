package com.icommerce.icommerceproject.dto.response.mapper;

import com.icommerce.icommerceproject.dto.projection.ProductInfo;
import com.icommerce.icommerceproject.dto.response.ProductCategoryDto;
import com.icommerce.icommerceproject.dto.response.ProductDto;
import com.icommerce.icommerceproject.entity.Product;
import com.icommerce.icommerceproject.entity.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category", target = "category", qualifiedByName = "categoryToDto")
    @Mapping(source = "imageUrl", target = "imageUrl")
    ProductDto toDto(Product product);

    default ProductCategoryDto categoryToDto(ProductCategory productCategory) {
        return ProductCategoryDto.builder()
                .name(productCategory.getName())
                .description(productCategory.getDescription())
                .id(productCategory.getId())
                .build();
    }

    @Mapping(source = "category", target = "category", qualifiedByName = "categoryToEntity")
    ProductDto toDto(ProductInfo product);

    default ProductCategory categoryToEntity(ProductCategoryDto productCategory) {
        return ProductCategory.builder()
                .name(productCategory.getName())
                .description(productCategory.getDescription())
                .id(productCategory.getId())
                .build();
    }

    Product toEntity(ProductDto productDto);
}
