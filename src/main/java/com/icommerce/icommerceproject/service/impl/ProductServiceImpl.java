package com.icommerce.icommerceproject.service.impl;

import com.icommerce.icommerceproject.dto.model.PagingResponseModel;
import com.icommerce.icommerceproject.dto.projection.ProductInfo;
import com.icommerce.icommerceproject.dto.response.ProductDto;
import com.icommerce.icommerceproject.dto.response.mapper.ProductCategoryMapper;
import com.icommerce.icommerceproject.dto.response.mapper.ProductDiscountMapper;
import com.icommerce.icommerceproject.dto.response.mapper.ProductMapper;
import com.icommerce.icommerceproject.entity.Product;
import com.icommerce.icommerceproject.repository.ProductCategoryRepository;
import com.icommerce.icommerceproject.repository.ProductDiscountRepository;
import com.icommerce.icommerceproject.repository.ProductRepository;
import com.icommerce.icommerceproject.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.EscapeCharacter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDiscountRepository productDiscountRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private ProductDiscountMapper productDiscountMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private EntityManager entityManager;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        // Init product
        Product product = productRepository.save(Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .quantity(productDto.getQuantity())
                .cost(productDto.getCost())
                .SKU(productDto.getSKU())
                .discount(productDiscountMapper.toEntity(productDto.getDiscount()))
                .category(productCategoryMapper.toEntity(productDto.getCategory()))
                .build());

        return productMapper.toDto(product);
    }

    @Override
    public PagingResponseModel<ProductInfo> loadProducts(Pageable pageable, String s) {
        Page<ProductInfo> productInfos = productRepository.loadProductProjection(pageable, s, EscapeCharacter.DEFAULT.getEscapeCharacter());

        return new PagingResponseModel<>(productInfos.map(item -> item));
    }

    @Override
    public ProductInfo loadProduct(Integer productId) {
        List<ProductInfo> productInfo = productRepository.loadAllProductProjectionByIds(Collections.singletonList(productId));

        return productInfo.get(0);
    }
}
