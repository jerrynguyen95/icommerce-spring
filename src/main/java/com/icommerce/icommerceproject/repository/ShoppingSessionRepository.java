package com.icommerce.icommerceproject.repository;

import com.icommerce.icommerceproject.entity.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingSessionRepository extends JpaRepository<ShoppingSession, Integer> {
    @Query(value = "select ss from ShoppingSession ss where ss.user.id = :userId")
    ShoppingSession findAllByUserId(Integer userId);
}