package com.icommerce.icommerceproject.service;

import com.icommerce.icommerceproject.dto.request.ProductCartRequestDto;
import com.icommerce.icommerceproject.dto.response.ProductCartDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CartService {
    List<ProductCartDto> loadProductCart(Integer userId);

    void deleteProductCart(Integer id);

    ProductCartDto addToCart(@RequestBody ProductCartRequestDto productCartDto);

    List<ProductCartDto> syncProductCart(List<ProductCartRequestDto> productCartRequestDtos);
}
