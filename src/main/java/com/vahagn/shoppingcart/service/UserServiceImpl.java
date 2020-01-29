package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.UserEntity;
import com.vahagn.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserEntity findByUserName(String userName) {

    return userRepository.findByUserName(userName);
  }
}
