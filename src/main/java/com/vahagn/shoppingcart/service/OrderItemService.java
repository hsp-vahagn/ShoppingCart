package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.OrderItemEntity;
import java.util.List;

public interface OrderItemService {

   void addItems(List<OrderItemEntity> orderItemEntities);

}
