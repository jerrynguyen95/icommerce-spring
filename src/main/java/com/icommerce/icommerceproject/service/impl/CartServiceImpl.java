package com.icommerce.icommerceproject.service.impl;

import com.icommerce.icommerceproject.dto.request.ProductCartRequestDto;
import com.icommerce.icommerceproject.dto.response.ProductCartDto;
import com.icommerce.icommerceproject.dto.response.mapper.ProductCartMapper;
import com.icommerce.icommerceproject.dto.response.mapper.ShoppingSessionMapper;
import com.icommerce.icommerceproject.entity.Product;
import com.icommerce.icommerceproject.entity.ProductCart;
import com.icommerce.icommerceproject.entity.ShoppingSession;
import com.icommerce.icommerceproject.entity.User;
import com.icommerce.icommerceproject.repository.ProductCartRepository;
import com.icommerce.icommerceproject.repository.ProductRepository;
import com.icommerce.icommerceproject.repository.ShoppingSessionRepository;
import com.icommerce.icommerceproject.repository.UserRepository;
import com.icommerce.icommerceproject.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    ProductCartRepository productCartRepository;

    @Autowired
    ShoppingSessionRepository shoppingSessionRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductCartMapper productCartMapper;

    @Autowired
    ShoppingSessionMapper shoppingSessionMapper;

    @Override
    public List<ProductCartDto> loadProductCart(Integer userId) {
        List<ProductCart> productCarts = productCartRepository.findAllByUserId(userId);
        return productCarts.stream().map(item -> productCartMapper.toDto(item)).collect(Collectors.toList());
    }

    @Override
    public void deleteProductCart(Integer id) {
        productCartRepository.deleteById(id);
    }

    @Override
    public ProductCartDto addToCart(ProductCartRequestDto productCartDto) {
        // Get current user shopping session
        ShoppingSession shoppingSession = shoppingSessionRepository.findAllByUserId(productCartDto.getUserId());

        if (shoppingSession == null) {
            User user = userRepository.getReferenceById(productCartDto.getUserId());
            shoppingSession = shoppingSessionRepository.save(ShoppingSession.builder().user(user).total(productCartDto.getTotal()).build());
        }

        Product product = productRepository.getReferenceById(productCartDto.getProductId());

        ProductCart productCart = productCartRepository.save(ProductCart.builder().shoppingSession(shoppingSession).product(product).quantity(productCartDto.getQuantity()).build());
        return productCartMapper.toDto(productCart);
    }

    @Override
    public List<ProductCartDto> syncProductCart(List<ProductCartRequestDto> productCartRequestDtos) {
        Map<Integer, Product> productHashMaps = productRepository.findAllById(productCartRequestDtos.stream()
                        .map(ProductCartRequestDto::getProductId)
                        .collect(Collectors.toList()))
                .stream().collect(Collectors
                        .toMap(Product::getId, Function.identity()));
        Map<Integer, ShoppingSession> shoppingSessionHashMaps = shoppingSessionRepository.findAllById(productCartRequestDtos.stream()
                        .map(ProductCartRequestDto::getSessionId)
                        .collect(Collectors.toList()))
                .stream().collect(Collectors
                        .toMap(ShoppingSession::getId, Function.identity()));

        List<ProductCart> productCarts = productCartRepository.saveAll(productCartRequestDtos.stream()
                .map(item -> {
                    ProductCart productCart = new ProductCart();
                    productCart.setId(item.getId());
                    productCart.setProduct(productHashMaps.get(item.getProductId()));
                    productCart.setShoppingSession(shoppingSessionHashMaps.get(item.getSessionId()));
                    productCart.setQuantity(item.getQuantity());
                    productCart.setCreatedOn(LocalDateTime.now());
                    productCart.setModifiedOn(LocalDateTime.now());
                    productCart.setModifiedBy("System");
                    productCart.setCreatedBy("System");

                    return productCart;
                }).collect(Collectors.toList()));

        return productCarts.stream().map(item -> productCartMapper.toDto(item)).collect(Collectors.toList());
    }
}
