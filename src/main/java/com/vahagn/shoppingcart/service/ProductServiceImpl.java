package com.vahagn.shoppingcart.service;

import com.vahagn.shoppingcart.dto.ProductDto;
import com.vahagn.shoppingcart.jpa.ProductEntity;
import com.vahagn.shoppingcart.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  @Transactional
  public ProductDto addProduct(ProductDto productDto) {
    ProductEntity productEntity = new ProductEntity();

    productEntity.setName(productDto.getName());
    productEntity.setType(productDto.getType());
    productEntity.setPrice(productDto.getPrice());
    productEntity.setCountInStock(productDto.getCountInStock());

    productRepository.save(productEntity);

    productDto.setId(productEntity.getId());

    return productDto;
  }

  @Override
  @Transactional(readOnly = true)
  public ProductDto getById(Long id) {

    ProductEntity productEntity = productRepository.findById(id).orElseThrow(RuntimeException::new);

    ProductDto productDto = new ProductDto(id);

    productDto.setName(productEntity.getName());
    productDto.setType(productEntity.getType());
    productDto.setPrice(productEntity.getPrice());
    productDto.setCountInStock(productEntity.getCountInStock());

    return productDto;
  }

  @Override
  @Transactional
  public ProductDto update(ProductDto productDto) {
    ProductEntity productEntity = productRepository.findById(productDto.getId()).orElseThrow(RuntimeException::new);
    productEntity.setName(productDto.getName());
    productEntity.setType(productDto.getType());
    productEntity.setPrice(productDto.getPrice());
    productEntity.setCountInStock(productDto.getCountInStock());

    productRepository.save(productEntity);

    productDto.setId(productEntity.getId());

    return productDto;
  }

  @Override
  @Transactional
  public void delete(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ProductDto> getAll(String sortBy) {
    List<ProductEntity> productEntities = productRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));

    List<ProductDto> productDtos = new ArrayList<>();

    for (ProductEntity productEntity : productEntities) {
      ProductDto productDto = new ProductDto();

      productDto.setId(productEntity.getId());
      productDto.setName(productEntity.getName());
      productDto.setType(productEntity.getType());
      productDto.setPrice(productEntity.getPrice());
      productDto.setCountInStock(productEntity.getCountInStock());
      productDtos.add(productDto);
    }
    return productDtos;
  }
}
