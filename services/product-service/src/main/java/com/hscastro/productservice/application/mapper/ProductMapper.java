package com.hscastro.productservice.application.mapper;

import com.hscastro.productservice.application.dto.input.ProductInput;
import com.hscastro.productservice.application.dto.output.ProductOutput;
import com.hscastro.productservice.domain.model.Product;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductInput input);
    ProductOutput toProductDTO(Product product);
}
