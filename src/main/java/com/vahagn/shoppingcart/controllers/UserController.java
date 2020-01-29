package com.vahagn.shoppingcart.controllers;

import com.vahagn.shoppingcart.jpa.CartEntity;
import com.vahagn.shoppingcart.model.CartItem;
import com.vahagn.shoppingcart.repository.CartRepository;
import com.vahagn.shoppingcart.service.CartService;
import com.vahagn.shoppingcart.service.OrderService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private OrderService orderService;

  @Autowired
  private CartService cartService;

  @PostMapping("/addToCart")
  public void addProductToCart(Principal principal, @RequestBody CartItem cartItem) {
    Long userId = 1L; // todo jwt - userRepository.findByName(principal.getName()).getId();
    cartService.saveProduct(userId, cartItem);
  }

  @PostMapping("/checkout")
  public void checkoutCartItems(Principal principal) {
    Long userId = 1L; // todo jwt - userRepository.findByName(principal.getName()).getId();

    List<CartEntity> cartItems = cartRepository.findAllByUserId(userId);

    orderService.createOrder(userId, cartItems);

  }

}
