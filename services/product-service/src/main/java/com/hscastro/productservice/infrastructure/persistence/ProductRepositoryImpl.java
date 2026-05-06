package com.hscastro.productservice.infrastructure.persistence;

import com.hscastro.productservice.application.dto.output.ProductOutput;
import com.hscastro.productservice.domain.model.Product;
import com.hscastro.productservice.domain.model.ProductId;
import com.hscastro.productservice.domain.repository.ProductRepository;
import com.hscastro.productservice.interfaces.exception.ProductValidationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product saved(Product product) {
        return jpaProductRepository.save(product);
    }

    @Override
    public Optional<Product> findByIdProduct(ProductId productId) {
        var product = jpaProductRepository.findById(productId)
                .orElseThrow(() -> new ProductValidationException("Product not found!"));

        return Optional.of(product);
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public void delete(ProductId productId) {

    }
}
