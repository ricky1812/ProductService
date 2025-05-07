package com.example.productservice.controllers;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.repository.projections.ProductTitleDescription;
import com.example.productservice.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(@Qualifier("selfProductService") ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id)
      throws ProductNotFoundException {
    return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
  }
  @GetMapping("/title")
  public ResponseEntity<List<ProductTitleDescription>> getAllProductWithTitleDescription(){
    return new ResponseEntity<>(
        productService.getProductTitleDescription(),
        HttpStatus.OK
    );
  }

  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productService.createProduct(product);
  }

  @DeleteMapping
  public void deleteProduct(@PathVariable("/{id}") Long id) {

  }

  @PatchMapping("/{id}")
  public void updateProduct(@PathVariable("id") Long productId, @RequestBody Product product) {

  }

  @PutMapping("/{id}")
  public void replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product) {

  }
  @GetMapping("/initialize")
  public void initialize() {
    productService.intializeProduct();
  }



}
