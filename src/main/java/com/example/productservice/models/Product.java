package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="products")
public class Product extends BaseModel {
  private Long id;
  private String title;
  private String description;
  private double price;
  @ManyToOne
  private Category category;
  private String image;

}
