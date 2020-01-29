package com.vahagn.shoppingcart.repository;

import com.vahagn.shoppingcart.jpa.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findByUserName(String userName);
}
