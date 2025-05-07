package com.example.productservice.service;

import com.example.productservice.dto.FakeStoreProductDTO;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repository.CategoryRepository;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.repository.projections.ProductTitleDescription;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("selfProductService")
public class SelfProductService implements ProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private RestTemplate restTemplate;

  public SelfProductService(ProductRepository productRepository,
      CategoryRepository categoryRepository, RestTemplate restTemplate) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
    this.restTemplate = restTemplate;
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
  public List<ProductTitleDescription> getProductTitleDescription() {
    return productRepository.getProductTitleDescription();
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

  @Override
  public void intializeProduct() {
    FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject(
        "https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
    List<Product> productList = Arrays.asList(fakeStoreProductDTOS).stream()
        .map(x -> convertFakeStroreProductDTOtoProduct(x)).collect(Collectors.toList());
    for (Product product : productList) {
      createProduct(product);
    }
  }

  private Product convertFakeStroreProductDTOtoProduct(FakeStoreProductDTO fakeStoreProductDTO) {
    Product product = new Product();
    product.setTitle(fakeStoreProductDTO.getTitle());
    product.setPrice(fakeStoreProductDTO.getPrice());
    // product.setDescription(fakeStoreProductDTO.getDescription());
    product.setImage(fakeStoreProductDTO.getImage());
    product.setCategory(new Category());
    product.getCategory().setValue(fakeStoreProductDTO.getCategory());
    return product;
  }

}
