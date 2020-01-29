package com.vahagn.shoppingcart.repository;

import com.vahagn.shoppingcart.jpa.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

}
