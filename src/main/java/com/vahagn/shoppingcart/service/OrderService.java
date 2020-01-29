package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.CartEntity;
import java.util.List;

public interface OrderService {

  void createOrder(Long userId, List<CartEntity> items);
}
