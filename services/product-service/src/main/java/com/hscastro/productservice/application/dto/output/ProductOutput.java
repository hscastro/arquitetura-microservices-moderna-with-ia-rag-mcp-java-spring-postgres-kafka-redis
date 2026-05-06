package com.hscastro.productservice.application.dto.output;

import com.hscastro.productservice.domain.model.ProductId;
import java.math.BigDecimal;


public record ProductOutput(
        ProductId id,
        String name,
        String description,
        BigDecimal price) {
}
