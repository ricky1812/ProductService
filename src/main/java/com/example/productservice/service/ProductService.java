package com.example.productservice.service;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.repository.projections.ProductTitleDescription;
import java.util.List;

public interface ProductService {
  Product getProduct(Long id) throws ProductNotFoundException;
  List<Product> getAllProducts();
  Product createProduct(Product product);
  List<ProductTitleDescription> getProductTitleDescription();
  void deleteProduct(Long id);
  void updateProduct(Long id,Product product);
  void replaceProduct(Long id,Product product);



}
