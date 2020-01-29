package com.vahagn.shoppingcart.repository;

import com.vahagn.shoppingcart.jpa.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
