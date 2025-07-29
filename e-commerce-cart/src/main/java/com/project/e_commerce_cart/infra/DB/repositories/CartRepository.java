package com.project.e_commerce_cart.infra.DB.repositories;

import com.project.e_commerce_cart.infra.DB.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<CartModel, UUID> {
}
