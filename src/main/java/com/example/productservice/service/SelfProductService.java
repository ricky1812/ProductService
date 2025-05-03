package com.example.productservice.service;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service("selfProductService")
public class SelfProductService implements ProductService {
  private ProductRepository productRepository;
  public SelfProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product getProduct(Long id) throws ProductNotFoundException {
    Optional<Product> optionalProduct = productRepository.findById(id);
    if(optionalProduct.isEmpty()){
      throw new ProductNotFoundException(id,"Product not found");
    }
    return optionalProduct.get();
  }

  @Override
  public List<Product> getAllProducts() {
    return List.of();
  }

  @Override
  public Product createProduct(Product product) {
    return null;
  }

  @Override
  public void deleteProduct(Long id) {

  }

  @Override
  public void updateProduct(Long id, Product product) {

  }

  @Override
  public void replaceProduct(Long id, Product product) {

  }
}
