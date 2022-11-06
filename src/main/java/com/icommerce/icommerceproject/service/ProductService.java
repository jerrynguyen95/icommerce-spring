package com.icommerce.icommerceproject.service;

import com.icommerce.icommerceproject.dto.model.PagingResponseModel;
import com.icommerce.icommerceproject.dto.projection.ProductInfo;
import com.icommerce.icommerceproject.dto.response.ProductDto;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);

    PagingResponseModel<ProductInfo> loadProducts(Pageable pageable, String s);

    ProductInfo loadProduct(Integer productId);
}
