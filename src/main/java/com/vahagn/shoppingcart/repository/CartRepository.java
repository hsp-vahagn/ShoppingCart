package com.vahagn.shoppingcart.repository;

import com.vahagn.shoppingcart.jpa.CartEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

  List<CartEntity> findAllByUserId(Long userId);

  void deleteAllByUserId(Long userId);

}
