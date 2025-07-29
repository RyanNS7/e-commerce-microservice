package com.project.e_commerce_cart.utils.mappers;

import com.project.e_commerce_cart.dtos.CartDTO;
import com.project.e_commerce_cart.infra.DB.models.CartModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMappers {

    @Mapping(target = "id", ignore = true)
    CartModel CartDTOtoCartModel(CartDTO cartDTO);

}
