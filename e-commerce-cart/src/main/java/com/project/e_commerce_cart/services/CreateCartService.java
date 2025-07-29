package com.project.e_commerce_cart.services;

import com.project.e_commerce_cart.dtos.CartDTO;
import com.project.e_commerce_cart.infra.DB.models.CartModel;
import com.project.e_commerce_cart.infra.DB.repositories.CartRepository;
import com.project.e_commerce_cart.utils.exceptions.InvalidCreation;
import com.project.e_commerce_cart.utils.mappers.CartMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartMappers cartMappers;

    public void create(CartDTO cartDTO){

        try{
            CartModel cartModel = cartMappers.CartDTOtoCartModel(cartDTO);

            cartRepository.save(cartModel);

        } catch (Exception e) {
            throw new InvalidCreation(e.getMessage());
        }

    }

}
