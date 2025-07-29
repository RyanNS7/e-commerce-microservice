package com.project.e_commerce_cart.infra.DB.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "CART_USER")
public class CartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String user_email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "id_cart_user", fetch = FetchType.LAZY)
    private Set<CartItemsModel> items = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Set<CartItemsModel> getItems() {
        return items;
    }

    public void setItems(Set<CartItemsModel> items) {
        this.items = items;
    }
}
