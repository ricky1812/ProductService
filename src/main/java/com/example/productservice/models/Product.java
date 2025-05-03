package com.example.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
  private Long id;
  private String title;
  private String description;
  private double price;
  private Category category;
  private String image;

}
