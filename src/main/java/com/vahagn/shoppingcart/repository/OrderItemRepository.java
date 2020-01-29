package com.vahagn.shoppingcart.repository;

import com.vahagn.shoppingcart.jpa.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Long> {

}
