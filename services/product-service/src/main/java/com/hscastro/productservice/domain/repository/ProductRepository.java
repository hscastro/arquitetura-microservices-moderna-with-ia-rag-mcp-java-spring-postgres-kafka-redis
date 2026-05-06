package com.hscastro.productservice.domain.repository;

import com.hscastro.productservice.application.dto.output.ProductOutput;
import com.hscastro.productservice.domain.model.Product;
import com.hscastro.productservice.domain.model.ProductId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ProductRepository {
    Product saved(Product product);
    Optional<Product> findByIdProduct(ProductId productId);
    List<Product> findAll();
    void delete(ProductId productId);
}
