package com.vahagn.shoppingcart.controllers;

import com.vahagn.shoppingcart.dto.ProductDto;
import com.vahagn.shoppingcart.jpa.OrderEntity;
import com.vahagn.shoppingcart.model.AddProduct;
import com.vahagn.shoppingcart.model.Approve;
import com.vahagn.shoppingcart.model.CartItem;
import com.vahagn.shoppingcart.repository.CartRepository;
import com.vahagn.shoppingcart.service.CartService;
import com.vahagn.shoppingcart.service.OrderItemService;
import com.vahagn.shoppingcart.service.OrderService;
import com.vahagn.shoppingcart.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


  @Autowired
  private OrderService orderService;

  @Autowired
  private CartService cartService;

  @Autowired
  private UserService userService;




  @PostMapping("/addToCart")
  public void addProductToCart(Principal principal, @RequestBody CartItem cartItem) {
    Long userId = userService.findByUserName(principal.getName()).getId();
    cartService.saveProduct(userId, cartItem);
  }

  @PostMapping("/checkout")
  public void checkout(Principal principal) {
    Long userId = userService.findByUserName(principal.getName()).getId();
    List<CartItem> cartItems = cartService.getAllByUserId(userId);
    orderService.createOrder(userId, cartItems);
  }
  @PostMapping("/approve")
  public ResponseEntity<OrderEntity> addProduct(@RequestBody Approve approve) {
    return ResponseEntity.ok(orderService.updateOrder(approve));
  }
}
