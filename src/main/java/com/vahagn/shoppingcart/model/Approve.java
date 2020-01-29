package com.vahagn.shoppingcart.model;

import com.vahagn.shoppingcart.jpa.OrderStatus;

public class Approve {

  private Long orderId;

  private OrderStatus status;

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
}
