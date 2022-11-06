package com.icommerce.icommerceproject.dto.response.mapper;

import com.icommerce.icommerceproject.dto.response.ProductCartDto;
import com.icommerce.icommerceproject.dto.response.ShoppingSessionDto;
import com.icommerce.icommerceproject.entity.ProductCart;
import com.icommerce.icommerceproject.entity.ShoppingSession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductCartMapper {

    @Mapping(source = "shoppingSession", target = "shoppingSession", qualifiedByName = "shoppingSessionToDto")
    ProductCartDto toDto(ProductCart productCategory);

    default ShoppingSessionDto shoppingSessionToDto(ShoppingSession shoppingSession) {
        return ShoppingSessionDto.builder()
                .id(shoppingSession.getId())
                .user(shoppingSession.getUser())
                .total(shoppingSession.getTotal())
                .build();
    }

    @Mapping(source = "shoppingSession", target = "shoppingSession", qualifiedByName = "shoppingSessionToEntity")
    ProductCart toEntity(ProductCartDto productCategory);

    default ShoppingSession shoppingSessionToEntity(ShoppingSessionDto shoppingSession) {
        return ShoppingSession.builder()
                .id(shoppingSession.getId())
                .user(shoppingSession.getUser())
                .total(shoppingSession.getTotal())
                .build();
    }
}
