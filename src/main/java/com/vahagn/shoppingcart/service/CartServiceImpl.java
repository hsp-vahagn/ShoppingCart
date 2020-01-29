package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.CartEntity;
import com.vahagn.shoppingcart.model.CartItem;
import com.vahagn.shoppingcart.repository.CartRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService {

  @Autowired
  private CartRepository cartRepository;

  @Override
  @Transactional
  public CartEntity saveProduct(Long userId, CartItem cartItem) {
    CartEntity cart = new CartEntity();
    cart.setUserId(userId);
    cart.setProductId(cartItem.getProductId());
    cart.setCount(cartItem.getCount());
    cartRepository.save(cart);
    return cart;
  }

  @Override
  @Transactional(readOnly = true)
  public List<CartItem> getAllByUserId(Long userId) {
    List<CartEntity> entities = cartRepository.findAllByUserId(userId);
    List<CartItem> carItems = new ArrayList<>();
    entities.forEach(entity -> {
      CartItem cartItem = new CartItem();
      cartItem.setId(entity.getId());
      cartItem.setProductId(entity.getProductId());
      cartItem.setCount(entity.getCount());
      carItems.add(cartItem);
    });
    return carItems;
  }
}
