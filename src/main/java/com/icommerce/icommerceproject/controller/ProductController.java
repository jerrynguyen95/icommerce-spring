package com.icommerce.icommerceproject.controller;

import com.icommerce.icommerceproject.dto.model.PagingResponseModel;
import com.icommerce.icommerceproject.dto.projection.ProductInfo;
import com.icommerce.icommerceproject.dto.response.ProductDto;
import com.icommerce.icommerceproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<PagingResponseModel<ProductInfo>> loadProducts(Pageable pageable, String s) {
        return ResponseEntity.ok(productService.loadProducts(pageable, s));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductInfo> loadProduct(@PathVariable(value = "id") Integer productId) {
        return ResponseEntity.ok(productService.loadProduct(productId));
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(new ProductDto());
        return ResponseEntity.ok(new ProductDto());
    }
}
