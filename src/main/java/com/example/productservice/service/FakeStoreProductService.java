package com.example.productservice.service;

import com.example.productservice.dto.FakeStoreProductDTO;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repository.projections.ProductTitleDescription;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeProductService")
public class FakeStoreProductService implements ProductService {

  private final RestTemplate restTemplate;

  public FakeStoreProductService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


  @Override
  public Product getProduct(Long id) throws ProductNotFoundException {
    throw new ProductNotFoundException(id,"Product not found for given id");
//    RestTemplate restTemplate = new RestTemplate();
//    FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(
//        "https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
//    return convertFakeStroreProductDTOtoProduct(fakeStoreProductDTO);

  }

  @Override
  public List<Product> getAllProducts() {
    FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject(
        "https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
    List<Product> productList = Arrays.asList(fakeStoreProductDTOS).stream()
        .map(x -> convertFakeStroreProductDTOtoProduct(x)).collect(Collectors.toList());
    return productList;

  }

  @Override
  public Product createProduct(Product product) {
    return null;
  }

  @Override
  public List<ProductTitleDescription> getProductTitleDescription() {
    return List.of();
  }

  @Override
  public void intializeProduct() {

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
    Product product = new Product();
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
