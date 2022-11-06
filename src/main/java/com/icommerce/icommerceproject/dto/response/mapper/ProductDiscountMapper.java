package com.icommerce.icommerceproject.dto.response.mapper;

import com.icommerce.icommerceproject.dto.response.ProductDiscountDto;
import com.icommerce.icommerceproject.entity.ProductDiscount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDiscountMapper {
    ProductDiscountDto toDto(ProductDiscount productDiscount);

    ProductDiscount toEntity(ProductDiscountDto productDiscountDto);
}
