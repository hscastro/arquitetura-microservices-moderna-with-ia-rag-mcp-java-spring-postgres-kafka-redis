package com.hscastro.productservice.application.usecase;

import com.hscastro.productservice.application.dto.input.ProductInput;
import com.hscastro.productservice.application.dto.output.ProductOutput;
import com.hscastro.productservice.application.mapper.ProductMapper;
import com.hscastro.productservice.domain.model.Product;
import com.hscastro.productservice.domain.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUsecase {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public CreateProductUsecase(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public ProductOutput execute(ProductInput input){
        var product = mapper.toEntity(input);
        var productOutput = mapper.toProductDTO(
                productRepository.saved(product));
        return productOutput;
    }
}
