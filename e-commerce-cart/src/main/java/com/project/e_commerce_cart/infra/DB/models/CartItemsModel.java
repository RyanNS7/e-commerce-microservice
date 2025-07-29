package com.project.e_commerce_cart.infra.DB.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "CART_ITEMS")
public class CartItemsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID id_item;

    @ManyToOne
    @JoinColumn(name = "cart_user_id", referencedColumnName = "id")
    private CartModel id_cart_user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId_item() {
        return id_item;
    }

    public void setId_item(UUID id_item) {
        this.id_item = id_item;
    }

    public CartModel getId_cart_user() {
        return id_cart_user;
    }

    public void setId_cart_user(CartModel id_cart_user) {
        this.id_cart_user = id_cart_user;
    }
}
