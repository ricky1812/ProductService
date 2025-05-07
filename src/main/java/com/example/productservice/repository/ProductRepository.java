package com.example.productservice.repository;

import com.example.productservice.models.Product;
import com.example.productservice.repository.projections.ProductTitleDescription;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Override
  Optional<Product> findById(Long aLong);

  @Override
  List<Product> findAll();

  Product save(Product product);

  @Query("select p.title as title ,p.description as description,p.price as price from products p")
  List<ProductTitleDescription> getProductTitleDescription();
}
