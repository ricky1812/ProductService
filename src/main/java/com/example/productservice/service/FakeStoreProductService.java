package com.example.productservice.service;

import com.example.productservice.dto.FakeStoreProductDTO;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class FakeStoreProductService implements ProductService{


  @Override
  public Product getProduct(Long id) {
    RestTemplate restTemplate = new RestTemplate();
    FakeStoreProductDTO fakeStoreProductDTO=restTemplate.getForObject(
        "https://fakestoreapi.com/products/"+id,
        FakeStoreProductDTO.class);
    return convertFakeStroreProductDTOtoProduct(fakeStoreProductDTO);

  }

  @Override
  public List<Product> getAllProducts() {
    return List.of();
  }

  @Override
  public Product createProduct(Product product) {
    return null;
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

  private Product convertFakeStroreProductDTOtoProduct(FakeStoreProductDTO fakeStoreProductDTO) {
    Product product=new Product();
    product.setId(fakeStoreProductDTO.getId());
    product.setTitle(fakeStoreProductDTO.getTitle());
    product.setPrice(fakeStoreProductDTO.getPrice());
    product.setDescription(fakeStoreProductDTO.getDescription());
    product.setImage(fakeStoreProductDTO.getImage());
    product.setCategory(new Category());
    product.getCategory().setValue(fakeStoreProductDTO.getCategory());
    return product;
  }
}
