package com.example.productservice.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductControllerTest {

  @Autowired
  private ProductController productController;
  @Mock
  private ProductService productService;

  @Test
  void getSingleProducTest() throws ProductNotFoundException {
    Product product = new Product();
    product.setId(10L);
    product.setTitle("title");
    product.setDescription("description");

    when(productService.getProduct(10L)).thenReturn(product);

    Product actualProduct = productService.getProduct(10L);
    assertEquals(product, actualProduct);

  }

  @Test
  void getAllProducts() {
  }

  @Test
  void createProduct() {
  }

  @Test
  void deleteProduct() {
  }

  @Test
  void updateProduct() {
  }

  @Test
  void replaceProduct() {
  }
}