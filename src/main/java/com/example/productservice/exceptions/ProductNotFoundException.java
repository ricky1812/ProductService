package com.example.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception {
  private Long productID;

  public ProductNotFoundException(Long productID,String message) {
    super(message);
    this.productID=productID;
  }

}
