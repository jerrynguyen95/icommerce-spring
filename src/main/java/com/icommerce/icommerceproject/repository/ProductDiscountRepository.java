package com.icommerce.icommerceproject.repository;

import com.icommerce.icommerceproject.entity.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Integer> {
}