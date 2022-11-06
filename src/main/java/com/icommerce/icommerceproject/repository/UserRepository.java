package com.icommerce.icommerceproject.repository;

import com.icommerce.icommerceproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}