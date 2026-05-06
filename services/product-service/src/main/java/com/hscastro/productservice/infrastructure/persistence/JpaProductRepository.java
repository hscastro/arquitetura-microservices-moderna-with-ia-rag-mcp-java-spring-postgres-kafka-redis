package com.hscastro.productservice.infrastructure.persistence;

import com.hscastro.productservice.domain.model.Product;
import com.hscastro.productservice.domain.model.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaProductRepository extends JpaRepository<Product, ProductId> {
}
