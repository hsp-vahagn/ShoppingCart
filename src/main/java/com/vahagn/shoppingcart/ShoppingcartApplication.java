package com.vahagn.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.vahagn.shoppingcart"})
@EnableJpaRepositories(basePackages = "com.vahagn.shoppingcart.repository")
public class ShoppingcartApplication {


  public static void main(String[] args) {
    SpringApplication.run(ShoppingcartApplication.class, args);

  }

}
