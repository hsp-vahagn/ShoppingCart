package com.vahagn.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.vahagn.shoppingcart"})
@EnableCaching
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.vahagn.shoppingcart.repository")
public class ShoppingcartApplication {


  public static void main(String[] args) {
    SpringApplication.run(ShoppingcartApplication.class, args);



  }

}
