package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.CartEntity;
import com.vahagn.shoppingcart.jpa.OrderEntity;
import com.vahagn.shoppingcart.jpa.OrderItemEntity;
import com.vahagn.shoppingcart.repository.OrderItemRepository;
import com.vahagn.shoppingcart.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderItemRepository orderItemRepository;

  @Override
  @Transactional
  public void createOrder(Long userId, List<CartEntity> items) {

    final OrderEntity order = new OrderEntity();
    order.setUserId(userId);

    final List<OrderItemEntity> orderItems = new ArrayList<>();

    items.forEach( item -> {
      final OrderItemEntity orderItem = new OrderItemEntity();

      orderItem.setOrders(order);
      orderItem.setProductId(item.getProductId());
      orderItem.setCount(item.getCount());
      orderItems.add(orderItem);
    });

    orderRepository.save(order);
    orderItemRepository.saveAll(orderItems);
  }
}
