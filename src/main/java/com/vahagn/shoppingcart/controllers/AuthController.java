package com.vahagn.shoppingcart.controllers;

import com.vahagn.shoppingcart.model.AuthRequest;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @PostMapping("/auth")
  public AuthRequest auth(@Valid @RequestBody AuthRequest authRequest, BindingResult bindingResult) {
    if(bindingResult.hasErrors()){
      return null;
    }
    return authRequest;
  }
}
