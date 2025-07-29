package com.project.e_commerce_cart.infra.DB.repositories;

import com.project.e_commerce_cart.infra.DB.models.CartItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemsRepository extends JpaRepository<CartItemsModel, UUID> {
}
