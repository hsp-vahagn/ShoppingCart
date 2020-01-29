package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.OrderEntity;
import com.vahagn.shoppingcart.jpa.OrderItemEntity;
import com.vahagn.shoppingcart.model.Approve;
import com.vahagn.shoppingcart.model.CartItem;
import com.vahagn.shoppingcart.repository.CartRepository;
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

  @Autowired
  private CartRepository cartRepository;

  @Override
  @Transactional
  public void createOrder(Long userId, List<CartItem> items) {

    OrderEntity order = new OrderEntity();
    order.setUserId(userId);

    List<OrderItemEntity> orderItems = new ArrayList<>();

    items.forEach(item -> {
      OrderItemEntity orderItem = new OrderItemEntity();

      orderItem.setOrders(order);
      orderItem.setProductId(item.getProductId());
      orderItem.setCount(item.getCount());
      orderItems.add(orderItem);
    });

    orderRepository.save(order);
    orderItemRepository.saveAll(orderItems);

    cartRepository.deleteAllByUserId(userId);

  }

  @Override
  public OrderEntity updateOrder(Approve approve) {
    OrderEntity orderEntity = orderRepository.findById(approve.getOrderId()).orElseThrow(RuntimeException::new);

    orderEntity.setStatus(approve.getStatus());
    orderRepository.save(orderEntity);
    return orderEntity;
  }

}
