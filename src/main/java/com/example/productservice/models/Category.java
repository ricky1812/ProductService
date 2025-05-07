package com.example.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="category")
public class Category extends BaseModel {
  private String value;
//  @OneToMany(mappedBy = "category")
//  List<Product> products;

}
