package com.example.productservice;

import com.example.productservice.repository.ProductRepository;
import com.example.productservice.repository.projections.ProductTitleDescription;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {

  @Autowired
  private ProductRepository productRepository;

  @Test
  void contextLoads() {
  }

  @Test
  void getProductTitleDescription() {
    List<ProductTitleDescription> productTitleDescriptionList = productRepository.getProductTitleDescription();
    for (ProductTitleDescription productTitleDescription : productTitleDescriptionList) {
      System.out.println(productTitleDescription.getTitle());
      System.out.println(productTitleDescription.getDescription());
      System.out.println(productTitleDescription.getPrice());
      System.out.println(".....................................................");
    }

  }

}
