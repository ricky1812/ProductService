package com.example.productservice.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {
  private Long id;
  private Date created_at;
  private Date updated_at;

}
