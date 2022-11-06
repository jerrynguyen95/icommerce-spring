package com.icommerce.icommerceproject.dto.response.mapper;

import com.icommerce.icommerceproject.dto.response.ShoppingSessionDto;
import com.icommerce.icommerceproject.entity.ShoppingSession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingSessionMapper {

    ShoppingSessionDto toDto(ShoppingSession productCategory);

    ShoppingSession toEntity(ShoppingSessionDto shoppingSessionDto);
}
