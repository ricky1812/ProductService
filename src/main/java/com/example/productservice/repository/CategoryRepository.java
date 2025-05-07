package com.example.productservice.repository;

import com.example.productservice.models.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Override
  Optional<Category> findById(Long aLong);

  Optional<Category> findByValue(String value);

  Category save(Category category);
}
