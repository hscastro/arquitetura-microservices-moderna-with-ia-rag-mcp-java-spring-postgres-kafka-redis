package com.hscastro.productservice.application.dto.input;

import com.hscastro.productservice.domain.model.ProductId;

import java.util.UUID;

public record ProductInput(
        ProductId id,
        String nome) {
}
