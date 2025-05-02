package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import java.util.ArrayList;
import java.util.List;
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
  @GetMapping("/{id}")
  public Product getSingleProduct(@PathVariable("id")  Long id){
    return new Product();

  }
  @GetMapping
  public List<Product>getAllProducts(){
    return new ArrayList<>();
  }
  @PostMapping
  public Product createProduct(){
    return new Product();
  }
  @DeleteMapping
  public void deleteProduct(@PathVariable("/{id}") Long id){

  }
  @PatchMapping("/{id}")
  public void updateProduct(@PathVariable("id") Long productId,@RequestBody Product product){

  }
  @PutMapping("/{id}")
  public void replaceProduct(@PathVariable("id") Long productId,@RequestBody Product product){

  }


}
