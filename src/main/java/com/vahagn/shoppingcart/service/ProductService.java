package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.dto.ProductDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService {

  ProductDto addProduct(ProductDto productDto);

  ProductDto getById(Long id);

  ProductDto update(ProductDto productDto);

  void delete(Long id);


  List<ProductDto> getAll(String sortBy);
}
