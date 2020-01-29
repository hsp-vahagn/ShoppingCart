package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.CartEntity;
import com.vahagn.shoppingcart.model.CartItem;
import com.vahagn.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService {

  @Autowired
  private CartRepository cartRepository;

  @Override
  @Transactional
  public CartEntity saveProduct(Long userId, CartItem product) {

    final CartEntity cart = new CartEntity();
    cart.setUserId(userId);
    cart.setProductId(product.getProductId());
    cart.setCount(product.getCount());

    cartRepository.save(cart);
    return cart;
  }
}
