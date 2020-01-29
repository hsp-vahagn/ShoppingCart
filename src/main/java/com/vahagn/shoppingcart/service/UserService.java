package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.jpa.UserEntity;

public interface UserService {

  UserEntity findByUserName(String userName);

}
