package com.icommerce.icommerceproject.repository;

import com.icommerce.icommerceproject.dto.projection.ProductInfo;
import com.icommerce.icommerceproject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select p.id as id, p.category as category, p.discount, p.cost as cost, p.SKU as SKU, p.description as description, p.quantity as quantity, p.name as name, p.imageUrl as imageUrl, p.discount as discount " +
            " from Product p where " +
            " :s is null or (" +
            " lower(p.name) like concat('%', :s, '%') escape :escapeCharacter or " +
            " lower(p.category.name) like concat('%', :s, '%') escape :escapeCharacter or " +
            " lower(p.SKU) like concat('%', :s, '%') escape :escapeCharacter or " +
            " lower(p.name) like concat('%', :s, '%') escape :escapeCharacter or " +
            " lower(p.description) like concat('%', :s, '%') escape :escapeCharacter " +
            " ) ")
    Page<ProductInfo> loadProductProjection(Pageable pageable, String s, char escapeCharacter);

    @Query(value = "select p.id as id, p.category as category, p.discount, p.cost as cost, p.SKU as SKU, p.description as description, p.quantity as quantity, p.name as name, p.imageUrl as imageUrl, p.discount as discount from Product p" +
            " where p.id in :productId")
    List<ProductInfo> loadAllProductProjectionByIds(List<Integer> productId);
}