package com.icommerce.icommerceproject.controller;

import com.icommerce.icommerceproject.dto.request.ProductCartRequestDto;
import com.icommerce.icommerceproject.dto.response.ProductCartDto;
import com.icommerce.icommerceproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart/{user-id}")
    public ResponseEntity<List<ProductCartDto>> loadProductCart(@PathVariable(value = "user-id") Integer userId) {
        return ResponseEntity.ok(cartService.loadProductCart(userId));
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity deleteProductCart(@PathVariable(value = "id") Integer id) {
        cartService.deleteProductCart(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/cart")
    public ResponseEntity<ProductCartDto> addToCart(@RequestBody ProductCartRequestDto productCartDto) {
        return ResponseEntity.ok(cartService.addToCart(productCartDto));
    }

    @PostMapping("/cart")
    public ResponseEntity<List<ProductCartDto>> syncProductCart(@RequestBody List<ProductCartRequestDto> productCartRequestDtos) {
        return ResponseEntity.ok(cartService.syncProductCart(productCartRequestDtos));
    }
}
