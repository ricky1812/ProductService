package com.example.productservice.controllerAdvice;

import com.example.productservice.dto.ProductNotFondDTo;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<ProductNotFondDTo> handleProductNotFoundException(
      ProductNotFoundException e) {
    ProductNotFondDTo productNotFondDTo = new ProductNotFondDTo();
    productNotFondDTo.setMessage(e.getMessage() + " " + e.getProductID());
    productNotFondDTo.setResolution("Ensure proper id is given");
    return new ResponseEntity<>(
        productNotFondDTo
        , HttpStatus.NOT_FOUND);
  }


}
