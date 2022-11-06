package com.icommerce.icommerceproject.repository;

import com.icommerce.icommerceproject.entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {
    @Query(value = "select pc from ProductCart pc where pc.shoppingSession.user.id = :userId")
    List<ProductCart> findAllByUserId(Integer userId);
}