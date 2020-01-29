package com.vahagn.shoppingcart.dto;

public class ProductDto {

  private Long id;

  private String name;

  private String type;

  private int price;

  private int countInStock;

  public ProductDto() {

  }

  public ProductDto(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getCountInStock() {
    return countInStock;
  }

  public void setCountInStock(int countInStock) {
    this.countInStock = countInStock;
  }
}
