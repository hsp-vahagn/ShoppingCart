package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.CartEntity;
import com.vahagn.shoppingcart.model.CartItem;
import java.util.List;

public interface CartService {

  CartEntity saveProduct(Long userId, CartItem product);

  List<CartItem> getAllByUserId(Long userId);

}
