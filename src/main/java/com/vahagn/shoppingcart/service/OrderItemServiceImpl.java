package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.OrderItemEntity;
import com.vahagn.shoppingcart.repository.OrderItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

  @Autowired
  private OrderItemRepository orderItemRepository;

  @Override
  @Transactional
  public void addItems(List<OrderItemEntity> orderItemEntities) {
    orderItemRepository.saveAll(orderItemEntities);
  }
}
