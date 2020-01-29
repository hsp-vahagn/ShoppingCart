package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.CartEntity;
import com.vahagn.shoppingcart.jpa.OrderEntity;
import com.vahagn.shoppingcart.model.Approve;
import com.vahagn.shoppingcart.model.CartItem;
import java.util.List;

public interface OrderService {

  void createOrder(Long userId, List<CartItem> items);

  OrderEntity updateOrder(Approve approve);
}
