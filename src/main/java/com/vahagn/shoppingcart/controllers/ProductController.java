package com.vahagn.shoppingcart.controllers;

import com.vahagn.shoppingcart.dto.ProductDto;
import com.vahagn.shoppingcart.model.AddProduct;
import com.vahagn.shoppingcart.model.UpdateProduct;
import com.vahagn.shoppingcart.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping("/product")
  public ResponseEntity<ProductDto> addProduct(@RequestBody AddProduct addProduct) {

    final ProductDto productDto = new ProductDto();
    productDto.setName(addProduct.getName());
    productDto.setType(addProduct.getType());
    productDto.setPrice(addProduct.getPrice());
    productDto.setCountInStock(addProduct.getCountInStock());

    return ResponseEntity.ok(productService.addProduct(productDto));
  }

  @PutMapping("/product")
  public ResponseEntity<ProductDto> updateProduct(@RequestBody UpdateProduct updateProduct) {

    Long id = updateProduct.getId();
    ProductDto productDto = new ProductDto(id);
    productDto.setName(updateProduct.getName());
    productDto.setType(updateProduct.getType());
    productDto.setPrice(updateProduct.getPrice());
    productDto.setCountInStock(updateProduct.getCountInStock());

    return ResponseEntity.ok(productService.update(productDto));
  }

  @DeleteMapping("/product")
  public ResponseEntity<UpdateProduct> delete(@RequestBody UpdateProduct updateProduct) {

    productService.delete(updateProduct.getId());

    return ResponseEntity.ok(updateProduct);
  }

  @GetMapping("/products")
  public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(defaultValue="price") String orderBy) {
    List<ProductDto> products = productService.getAll(orderBy);
    return ResponseEntity.ok(products);
  }
}
