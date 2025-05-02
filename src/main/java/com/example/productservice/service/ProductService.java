package com.example.productservice.service;

import com.example.productservice.models.Product;
import java.util.List;

public interface ProductService {
  Product getProduct(Long id);
  List<Product> getAllProducts();
  Product createProduct(Product product);
  void deleteProduct(Long id);
  void updateProduct(Long id,Product product);
  void replaceProduct(Long id,Product product);



}
