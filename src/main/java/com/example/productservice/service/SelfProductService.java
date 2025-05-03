package com.example.productservice.service;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repository.CategoryRepository;
import com.example.productservice.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service("selfProductService")
public class SelfProductService implements ProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public SelfProductService(ProductRepository productRepository,
      CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Product getProduct(Long id) throws ProductNotFoundException {
    Optional<Product> optionalProduct = productRepository.findById(id);
    if (optionalProduct.isEmpty()) {
      throw new ProductNotFoundException(id, "Product not found");
    }
    return optionalProduct.get();
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product createProduct(Product product) {
    if (product.getCategory() != null) {
      if (product.getCategory().getId() == null) {
        Category category = product.getCategory();
        Optional<Category> categoryFrpmDb = categoryRepository.findByValue(category.getValue());
        if (categoryFrpmDb.isEmpty()) {
          category = categoryRepository.save(category);
        } else {
          category = categoryFrpmDb.get();
        }
        product.setCategory(category);
      }
    } else {
      throw new RuntimeException("Category is null");
    }
    return productRepository.save(product);
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
